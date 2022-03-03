package com.api.crudbase.services;

import com.api.crudbase.models.Course;
import com.api.crudbase.repositories.CourseRepository;
import com.api.crudbase.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
