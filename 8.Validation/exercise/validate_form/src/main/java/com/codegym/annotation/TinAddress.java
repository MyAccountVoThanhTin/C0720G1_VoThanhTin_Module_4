package com.codegym.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidateTinAddress.class)
@Documented
public @interface TinAddress {
    String message() default "Format Address is wrong.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
