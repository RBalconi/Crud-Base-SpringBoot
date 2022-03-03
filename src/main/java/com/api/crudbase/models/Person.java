package com.api.crudbase.models;

import com.api.crudbase.shared.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table (name = "PERSON")
public class Person extends BaseModel {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CELLPHONE", nullable = false, length = 12)
    private String cellphone;

    @Column(name = "PHONE", nullable = false, length = 11)
    private String phone;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "EMAIL", unique = true)
    private String email;

}

