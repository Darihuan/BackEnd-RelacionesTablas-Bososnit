package com.example.relacionesentretablas.core.inputValidation;

import com.example.relacionesentretablas.core.validation.EmailValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailvalidationAnotation {
    String message() default "El email debe seguir un formato valido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
