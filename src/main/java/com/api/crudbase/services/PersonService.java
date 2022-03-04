package com.api.crudbase.services;

import com.api.crudbase.models.Person;
import com.api.crudbase.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Transactional
    public Person update(Person person) {
        if(person.getId() == null) {
            throw new IllegalArgumentException("Person Id cannot be null");
        }
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(UUID id) {
        return personRepository.findById(id);
    }

    public void delete(Person obj) {
        personRepository.delete(obj);
    }
}
