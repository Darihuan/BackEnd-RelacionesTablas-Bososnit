package com.example.relacionesentretablas.core.inputValidation;

import com.example.relacionesentretablas.core.validation.InitialDateValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = InitialDateValidation.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InitialDateValidationAnotation {
    String message() default "La Fecha inicial no puede ser nula y debe ser una fecha del pasado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
