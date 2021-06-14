package com.harshit.springdemo.mvc;

import java.util.LinkedHashMap;

import javax.validation.constraints.NotNull;

public class Student {
	
	@NotNull(message = "is required")
	private String firstName;
	
	@NotNull(message = "is required")
	private String lastName;
	
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	
	private String favouriteLanguage;
	private String[] operatingSystems;
	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public Student() {
		countryOptions=new LinkedHashMap<String, String>();
		countryOptions.put("BR","Brazil");
		countryOptions.put("FR","France");
		countryOptions.put("GE","Germany");
		countryOptions.put("IN","India");
		countryOptions.put("US","United States");
		
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}
	
	
}
