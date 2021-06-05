package com.harshit.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) //retain this annotation in the bytecode and also use this at runtime by jvm
public @interface CourseCode {
	
	//define defaut course code
	public String value() default "LUV"; //methodname is the actual parameter of the annotation
	//define default error message
	public String message() default "must start with LUV";
	//define default groups
	public Class<?>[] groups() default {};
	//define default payloads
	public Class<? extends Payload>[] payload() default {};
}
