package com.api.crudbase.controllers;

import com.api.crudbase.models.Course;
import com.api.crudbase.models.dtos.CourseDto;
import com.api.crudbase.services.CourseService;
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
@RequestMapping("/course")
public class CourseController {

    public final CourseService courseService;
    private final String MESSAGE_NOT_FOUND = "Course not found";
    private final String MESSAGE_FOUND = "Course found";
    private final String MESSAGE_CREATED_SUCCESS = "Course created successfully";
    private final String MESSAGE_CREATED_FAILED = "Course created failed";
    private final String MESSAGE_UPDATED_SUCCESS = "Course updated successfully";
    private final String MESSAGE_UPDATED_FAILED = "Course updated failed";
    private final String MESSAGE_DELETED_SUCCESS = "Course deleted successfully";
    private final String MESSAGE_DELETED_FAILED = "Course deleted failed";

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseAPI> getAllCourses() {
        List<Course> courses = courseService.findAll();

        var response = new ResponseAPI();
        if (courses.isEmpty()) {
            response.setMessage(MESSAGE_NOT_FOUND);
            response.setSituation(SituationResponseAPI.SUCCESS);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            response.setListObject(Collections.singletonList(courses));
            response.setMessage(MESSAGE_FOUND);
            response.setSituation(SituationResponseAPI.SUCCESS);
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseAPI> getByIdCourse(@PathVariable UUID id) {
        Course course = courseService.findById(id).orElse(null);

        var response = new ResponseAPI();
        if (course == null) {
            response.setMessage(MESSAGE_NOT_FOUND);
            response.setSituation(SituationResponseAPI.ERROR);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            response.setObject(course);
            response.setMessage(MESSAGE_FOUND);
            response.setSituation(SituationResponseAPI.SUCCESS);
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseAPI> createCourse(@RequestBody @Valid CourseDto courseDto) {
        var course = new Course();
        BeanUtils.copyProperties(courseDto, course);

        var response = new ResponseAPI();
        try {
            response.setObject(courseService.save(course));
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
    public ResponseEntity<ResponseAPI> updateCourse(@PathVariable UUID id,
                                                    @RequestBody @Valid CourseDto courseDto) {
        Course courseById = courseService.findById(id).orElse(null);
        var response = new ResponseAPI();

        if (courseById == null) {
            response.setMessage(MESSAGE_NOT_FOUND);
            response.setSituation(SituationResponseAPI.ERROR);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        var course = new Course();
        BeanUtils.copyProperties(courseDto, course);
        course.setId(courseById.getId());
        course.setCreatedAt(courseById.getCreatedAt());

        try {
            response.setObject(courseService.update(course));
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
    public ResponseEntity<ResponseAPI> deleteCourse(@PathVariable UUID id) {

        Course course = courseService.findById(id).orElse(null);

        var response = new ResponseAPI();
        if (course == null) {
            response.setMessage(MESSAGE_NOT_FOUND);
            response.setSituation(SituationResponseAPI.ERROR);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        try {
            courseService.delete(course);
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
