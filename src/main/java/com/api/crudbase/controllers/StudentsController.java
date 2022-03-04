package com.api.crudbase.controllers;

import com.api.crudbase.models.Students;
import com.api.crudbase.models.dtos.StudentsDto;
import com.api.crudbase.services.StudentsService;
import com.api.crudbase.shared.ResponseAPI;
import com.api.crudbase.shared.enumerations.SituationResponseAPI;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentsController {

    public final StudentsService studentsService;
    private final String MESSAGE_NOT_FOUND = "Students not found";
    private final String MESSAGE_FOUND = "Students found";
    private final String MESSAGE_CREATED_SUCCESS = "Students created successfully";
    private final String MESSAGE_CREATED_FAILED = "Students created failed";
    private final String MESSAGE_UPDATED_SUCCESS = "Students updated successfully";
    private final String MESSAGE_UPDATED_FAILED = "Students updated failed";
    private final String MESSAGE_DELETED_SUCCESS = "Students deleted successfully";
    private final String MESSAGE_DELETED_FAILED = "Students deleted failed";

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseAPI> getAllStudentss() {
        List<Students> studenties = studentsService.findAll();

        var response = new ResponseAPI();
        if (studenties.isEmpty()) {
            response.setMessage(MESSAGE_NOT_FOUND);
            response.setSituation(SituationResponseAPI.SUCCESS);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            response.setListObject(Collections.singletonList(studenties));
            response.setMessage(MESSAGE_FOUND);
            response.setSituation(SituationResponseAPI.SUCCESS);
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseAPI> getByIdStudents(@PathVariable UUID id) {
        Students students = studentsService.findById(id).orElse(null);

        var response = new ResponseAPI();
        if (students == null) {
            response.setMessage(MESSAGE_NOT_FOUND);
            response.setSituation(SituationResponseAPI.ERROR);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            response.setObject(students);
            response.setMessage(MESSAGE_FOUND);
            response.setSituation(SituationResponseAPI.SUCCESS);
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseAPI> createStudents(@RequestBody @Valid StudentsDto studentsDto) {
        var students = new Students();
        BeanUtils.copyProperties(studentsDto, students);

        var response = new ResponseAPI();
        try {
            response.setObject(studentsService.save(students));
            response.setSituation(SituationResponseAPI.SUCCESS);
            response.setMessage(MESSAGE_CREATED_SUCCESS);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.setSituation(SituationResponseAPI.ERROR);
            response.setMessage(MESSAGE_CREATED_FAILED);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseAPI> updateStudents(@PathVariable UUID id,
                                               @RequestBody @Valid StudentsDto studentsDto) {
        Students studentsById = studentsService.findById(id).orElse(null);
        var response = new ResponseAPI();

        if (studentsById == null) {
            response.setMessage(MESSAGE_NOT_FOUND);
            response.setSituation(SituationResponseAPI.ERROR);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        var students = new Students();
        BeanUtils.copyProperties(studentsDto, students);
        students.setId(studentsById.getId());
        students.setCreatedAt(studentsById.getCreatedAt());

        try {
            response.setObject(studentsService.update(students));
            response.setSituation(SituationResponseAPI.SUCCESS);
            response.setMessage(MESSAGE_UPDATED_SUCCESS);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setSituation(SituationResponseAPI.ERROR);
            response.setMessage(MESSAGE_UPDATED_FAILED);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseAPI> deleteStudents(@PathVariable UUID id) {

        Students students = studentsService.findById(id).orElse(null);

        var response = new ResponseAPI();
        if (students == null) {
            response.setMessage(MESSAGE_NOT_FOUND);
            response.setSituation(SituationResponseAPI.ERROR);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        try {
            studentsService.delete(students);
            response.setSituation(SituationResponseAPI.SUCCESS);
            response.setMessage(MESSAGE_DELETED_SUCCESS);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setSituation(SituationResponseAPI.ERROR);
            response.setMessage(MESSAGE_DELETED_FAILED);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


}
