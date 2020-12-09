package com.codegym.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class ValidateTinAddress implements ConstraintValidator<TinAddress,String> {

    @Override
    public void initialize(TinAddress constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("[A-Z]+");
    }
}
