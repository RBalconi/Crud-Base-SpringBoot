package com.api.crudbase.repositories;

import com.api.crudbase.models.Course;
import com.api.crudbase.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
}
