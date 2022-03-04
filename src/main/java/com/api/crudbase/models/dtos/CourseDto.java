package com.api.crudbase.models.dtos;

import com.api.crudbase.models.enumerations.Situation;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CourseDto {

    @NotBlank
    private String name;

//    @NotBlank
    private Situation situation;

}
