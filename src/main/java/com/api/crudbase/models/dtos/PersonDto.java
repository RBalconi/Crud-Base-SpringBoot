package com.api.crudbase.models.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PersonDto {

    @NotBlank
    private String name;

    @NotBlank
    @Size(max = 12)
    private String cellphone;

    @NotBlank
    @Size(max = 12)
    private String phone;

    @NotBlank
    private String address;

//    @Email
//    @UniqueElements
    private String email;

}
