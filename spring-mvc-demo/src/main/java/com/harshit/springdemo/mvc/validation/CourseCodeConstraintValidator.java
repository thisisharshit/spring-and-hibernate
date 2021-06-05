package com.harshit.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{
	
	
	private String coursePrefix;
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix=theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode,
			ConstraintValidatorContext theConstraintValidatorContext) {//additional error message in this variable
		
		boolean result;
		
		if(theCode==null) return true;
		else return theCode.startsWith(coursePrefix);
		
		//return result;
	}

}
