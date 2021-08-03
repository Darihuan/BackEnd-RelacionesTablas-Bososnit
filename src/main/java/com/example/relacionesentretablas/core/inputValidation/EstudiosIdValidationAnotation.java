package com.example.relacionesentretablas.core.inputValidation;

import com.example.relacionesentretablas.core.validation.EstudiosIDValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EstudiosIDValidation.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EstudiosIdValidationAnotation {
    String message() default "El estudio con ID no existe en la base de datos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
