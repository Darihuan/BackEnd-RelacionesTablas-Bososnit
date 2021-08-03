package com.example.relacionesentretablas.core.validation;

import com.example.relacionesentretablas.core.error.UnprocesableException;
import com.example.relacionesentretablas.core.inputValidation.InitialDateValidationAnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class InitialDateValidation implements ConstraintValidator<InitialDateValidationAnotation, Date> {
    public void initialize(InitialDateValidationAnotation constraint) {
    }

    public boolean isValid(Date fecha, ConstraintValidatorContext context) throws UnprocesableException {
        if (fecha != null) {
            return true;
        }
        throw new UnprocesableException("La fecha de inicio no puede ser un campo nulo");
    }
}
