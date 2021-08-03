package com.example.relacionesentretablas.core.inputValidation;

import com.example.relacionesentretablas.core.validation.ProfesorIDValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ProfesorIDValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProfesorIDValidationAnotation {
    String message() default "El ID de profesor debe corresponder a un profesor existente en la base de datos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
