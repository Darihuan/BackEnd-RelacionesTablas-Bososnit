package com.example.relacionesentretablas.core.validation;

import com.example.relacionesentretablas.core.error.UnprocesableException;
import com.example.relacionesentretablas.core.inputValidation.ProfesorIDValidationAnotation;
import com.example.relacionesentretablas.profesor.application.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProfesorIDValidation implements ConstraintValidator<ProfesorIDValidationAnotation, Integer> {
    @Autowired
    IProfesorService servicio;

    public void initialize(ProfesorIDValidationAnotation constraint) {
    }

    public boolean isValid(Integer id, ConstraintValidatorContext context) throws UnprocesableException {
        if (id != null) {
            servicio.findById(id).orElseThrow(() -> new UnprocesableException("No existe registro de profesor con id:" + id));
            return true;
        }
        throw new UnprocesableException("El id de profesor no puede ser nulo");
    }
}
