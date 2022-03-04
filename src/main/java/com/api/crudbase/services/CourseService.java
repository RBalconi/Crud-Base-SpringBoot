package com.api.crudbase.services;

import com.api.crudbase.models.Course;
import com.api.crudbase.models.Person;
import com.api.crudbase.repositories.CourseRepository;
import com.api.crudbase.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService {

    final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    public Course update(Course course) {
        if(course.getId() == null) {
            throw new IllegalArgumentException("Course Id cannot be null");
        }
        return courseRepository.save(course);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> findById(UUID id) {
        return courseRepository.findById(id);
    }

    public void delete(Course obj) {
        courseRepository.delete(obj);
    }
}
