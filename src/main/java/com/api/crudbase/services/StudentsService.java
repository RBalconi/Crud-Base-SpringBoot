package com.api.crudbase.services;

import com.api.crudbase.models.Students;
import com.api.crudbase.repositories.StudentsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentsService {

    final StudentsRepository studentsRepository;

    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Transactional
    public Students save(Students students) {
        return studentsRepository.save(students);
    }

    @Transactional
    public Students update(Students students) {
        if(students.getId() == null) {
            throw new IllegalArgumentException("Students Id cannot be null");
        }
        return studentsRepository.save(students);
    }

    public List<Students> findAll() {
        return studentsRepository.findAll();
    }

    public Optional<Students> findById(UUID id) {
        return studentsRepository.findById(id);
    }

    public void delete(Students obj) {
        studentsRepository.delete(obj);
    }
}
