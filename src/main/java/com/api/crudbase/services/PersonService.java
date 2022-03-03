package com.api.crudbase.services;

import com.api.crudbase.models.Person;
import com.api.crudbase.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonService {

    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public Person save(Person person) {
        return personRepository.save(person);
    }
}
