package com.api.crudbase.models;

import com.api.crudbase.models.enumerations.Situation;
import com.api.crudbase.shared.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "COURSES")
public class Course extends BaseModel {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "SITUATION", nullable = false)
    private Situation situation;
}
