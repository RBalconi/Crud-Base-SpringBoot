package com.api.crudbase.controllers;

import com.api.crudbase.models.Person;
import com.api.crudbase.models.dtos.PersonDto;
import com.api.crudbase.services.PersonService;
import com.api.crudbase.shared.ResponseAPI;
import com.api.crudbase.shared.enumerations.SituationResponseAPI;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {

    public final PersonService personService;
    private final String MESSAGE_NOT_FOUND = "Person not found";
    private final String MESSAGE_FOUND = "Person found";
    private final String MESSAGE_CREATED_SUCCESS = "Person created successfully";
    private final String MESSAGE_CREATED_FAILED = "Person created failed";
    private final String MESSAGE_UPDATED_SUCCESS = "Person updated successfully";
    private final String MESSAGE_UPDATED_FAILED = "Person updated failed";
    private final String MESSAGE_DELETED_SUCCESS = "Person deleted successfully";
    private final String MESSAGE_DELETED_FAILED = "Person deleted failed";

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseAPI> getAllPersons() {
        List<Person> persons = personService.findAll();

        var response = new ResponseAPI();
        if (persons.isEmpty()) {
            response.setMessage(MESSAGE_NOT_FOUND);
            response.setSituation(SituationResponseAPI.SUCCESS);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            response.setListObject(Collections.singletonList(persons));
            response.setMessage(MESSAGE_FOUND);
            response.setSituation(SituationResponseAPI.SUCCESS);
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseAPI> getByIdPerson(@PathVariable UUID id) {
        Person person = personService.findById(id).orElse(null);

        var response = new ResponseAPI();
        if (person == null) {
            response.setMessage(MESSAGE_NOT_FOUND);
            response.setSituation(SituationResponseAPI.ERROR);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            response.setObject(person);
            response.setMessage(MESSAGE_FOUND);
            response.setSituation(SituationResponseAPI.SUCCESS);
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseAPI> createPerson(@RequestBody @Valid PersonDto personDto) {
        var person = new Person();
        BeanUtils.copyProperties(personDto, person);

        var response = new ResponseAPI();
        try {
            response.setObject(personService.save(person));
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
    public ResponseEntity<ResponseAPI> updatePerson(@PathVariable UUID id,
                                               @RequestBody @Valid PersonDto personDto) {
        Person personById = personService.findById(id).orElse(null);
        var response = new ResponseAPI();

        if (personById == null) {
            response.setMessage(MESSAGE_NOT_FOUND);
            response.setSituation(SituationResponseAPI.ERROR);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        var person = new Person();
        BeanUtils.copyProperties(personDto, person);
        person.setId(personById.getId());
        person.setCreatedAt(personById.getCreatedAt());

        try {
            response.setObject(personService.update(person));
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
    public ResponseEntity<ResponseAPI> deletePerson(@PathVariable UUID id) {

        Person person = personService.findById(id).orElse(null);

        var response = new ResponseAPI();
        if (person == null) {
            response.setMessage(MESSAGE_NOT_FOUND);
            response.setSituation(SituationResponseAPI.ERROR);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        try {
            personService.delete(person);
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
