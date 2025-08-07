package com.anjori.custom_validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private  String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode){
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext context) {
        if(theCode == null || theCode.isEmpty() || theCode.trim().isEmpty()){
            return false;
        }
        boolean result = theCode.startsWith(coursePrefix);
        return result;
    }
}
