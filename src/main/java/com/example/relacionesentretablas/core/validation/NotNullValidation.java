package com.example.relacionesentretablas.core.validation;

import com.example.relacionesentretablas.core.error.UnprocesableException;
import com.example.relacionesentretablas.core.inputValidation.NotNulllvalidationAnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullValidation implements ConstraintValidator<NotNulllvalidationAnotation, String> {


    @Override
    public void initialize(NotNulllvalidationAnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String campo, ConstraintValidatorContext context) throws UnprocesableException {
        if (campo != null) {
            return true;
        }
        throw new UnprocesableException("El campo no puede ser nulo");
    }
}