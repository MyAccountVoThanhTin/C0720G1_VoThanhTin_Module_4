package com.codegym.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateTinName2 implements ConstraintValidator<TinName2,String> {
    @Override
    public void initialize(TinName2 constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("[A-Za-z]+");
    }
}
