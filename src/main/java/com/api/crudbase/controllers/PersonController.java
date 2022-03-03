package com.api.crudbase.controllers;

import com.api.crudbase.models.Person;
import com.api.crudbase.models.dtos.PersonDto;
import com.api.crudbase.services.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
// test without @crossOrigin
@RequestMapping("/person")
public class PersonController {

    final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody @Valid PersonDto personDto) {
        var person = new Person();
        BeanUtils.copyProperties(personDto, person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
    }
}
