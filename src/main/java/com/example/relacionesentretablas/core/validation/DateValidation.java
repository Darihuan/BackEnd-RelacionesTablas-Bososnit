package com.example.relacionesentretablas.core.validation;

import com.example.relacionesentretablas.core.error.UnprocesableException;
import com.example.relacionesentretablas.core.inputValidation.DateValidationAnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class DateValidation implements ConstraintValidator<DateValidationAnotation, Date> {
    @Override
    public void initialize(DateValidationAnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Date fecha, ConstraintValidatorContext context) throws UnprocesableException {
        if (fecha != null) {
            return true;
        }
        throw new UnprocesableException("El fecha no valida");
    }
}