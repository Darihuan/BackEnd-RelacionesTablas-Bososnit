package com.example.relacionesentretablas.core.validation;

import com.example.relacionesentretablas.core.error.UnprocesableException;
import com.example.relacionesentretablas.core.inputValidation.PersonaIDValidationAnotation;
import com.example.relacionesentretablas.persona.application.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PersonaIDValidation implements ConstraintValidator<PersonaIDValidationAnotation, Integer> {

    @Autowired
    IPersonaService servicio;

    public void initialize(PersonaIDValidationAnotation constraint) {
    }

    public boolean isValid(Integer id, ConstraintValidatorContext context) throws UnprocesableException {
        if (id != null) {

            servicio.findById(id).orElseThrow(() -> new UnprocesableException("No existe registro de persona con id:" + id));
            return true;
        }
        throw new UnprocesableException("El id de persona no puede ser nulo");

    }
}
