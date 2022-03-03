package com.api.crudbase.models;

import com.api.crudbase.shared.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table (name = "STUDENTS")
public class Students extends BaseModel {

    @OneToOne
    private Course course;

    @OneToOne
    private Person person;

//    private Professor professor;
}
