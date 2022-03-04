package com.api.crudbase.models.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PersonDto {

    private UUID id;

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

    @Email
    @NotBlank
    private String email;

}
