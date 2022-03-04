package com.api.crudbase.repositories;

import com.api.crudbase.models.Person;
import com.api.crudbase.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentsRepository extends JpaRepository<Students, UUID> {
}
