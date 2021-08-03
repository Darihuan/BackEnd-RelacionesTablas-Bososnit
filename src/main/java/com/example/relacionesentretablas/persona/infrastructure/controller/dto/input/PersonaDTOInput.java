package com.example.relacionesentretablas.persona.infrastructure.controller.dto.input;

import com.example.relacionesentretablas.core.inputValidation.DateValidationAnotation;
import com.example.relacionesentretablas.core.inputValidation.EmailvalidationAnotation;
import com.example.relacionesentretablas.core.inputValidation.NotNulllvalidationAnotation;
import com.example.relacionesentretablas.core.inputValidation.UsuarioValidationAnotation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class PersonaDTOInput {

    Integer id;
    @UsuarioValidationAnotation
    String user;

    @NotNulllvalidationAnotation(message = "el campo password no puede ser nulo")
    String password;
    @NotNulllvalidationAnotation(message = "el campo surname no puede ser nulo")
    String surname;
    @EmailvalidationAnotation(message = "El campo email personal no puede ser nulo y dede tener un formato correcto")
    String company_email;
    @EmailvalidationAnotation(message = "El campo email personal no puede ser nulo y dede tener un formato correcto")
    String personal_email;
    @NotNulllvalidationAnotation(message = "el campo city no puede ser nulo")
    String city;
    @NotNull(message = "El campo active no puede ser nulo")
    Boolean active;
    @DateValidationAnotation(message = "el campo created date no puede ser nulo ")
    Date created_Date;
    String imagen_url;
    Date termination_Date;


}
