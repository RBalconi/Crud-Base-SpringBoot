package com.api.crudbase.models;

import com.api.crudbase.models.enumerations.Situation;
import com.api.crudbase.shared.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "COURSES")
public class Course extends BaseModel {

    @Column(name = "NAME", nullable = false)
    private String name;

//    @Column(name = "NAME", nullable = false)
//    private Situation situation;
}
