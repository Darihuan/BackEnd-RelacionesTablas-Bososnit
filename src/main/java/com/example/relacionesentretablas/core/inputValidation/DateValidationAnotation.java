package com.example.relacionesentretablas.core.inputValidation;

import com.example.relacionesentretablas.core.validation.DateValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DateValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateValidationAnotation {
    String message() default "La fecha debe no puede ser nula y ser una fecha del pasado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}