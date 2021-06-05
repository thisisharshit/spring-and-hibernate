package com.harshit.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.harshit.springdemo.mvc.validation.CourseCode;


public class Customer {
	
	private String firstName;
	
	@NotNull(message = "is required") //is required will be printed as message if null
	@Size(min=1,message = "is required")
	private String lastName;
	
	@Min(value=0,message = "must be greater than or equal to 0")
	@Max(value=10,message = "must be less than or equal to 10")
	@NotNull(message = "is required")
	private Integer freePasses;
	
	@Pattern(regexp="[a-zA-Z0-9]{5}",message = "must be 5 chars/digits")
	private String postalCode;
	
	@CourseCode(value = "TOPS",message = "must start with TOPS")
	private String courseCode;
		
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
