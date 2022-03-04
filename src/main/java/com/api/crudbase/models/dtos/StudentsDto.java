package com.api.crudbase.models.dtos;

import com.api.crudbase.models.Course;
import com.api.crudbase.models.Person;
import com.api.crudbase.models.enumerations.Situation;
import lombok.Data;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class StudentsDto {

    private UUID id;

    private Course course;

    private Person person;

}
