package com.example.relacionesentretablas.core.inputValidation;

import com.example.relacionesentretablas.core.validation.EstudianteIDValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EstudianteIDValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EstudianteIDValidationAnotation {
    String message() default "El ID de Estudiante debe corresponder a una persona existente en la base de datos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
