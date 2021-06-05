package com.harshit.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Driver {

	public static void main(String[] args) {
		try {
			//create the object mapper
			ObjectMapper mapper=new ObjectMapper();
			
			//read the JSON file and map/convert to Java POJO
			Student student=mapper.readValue(new File("data/sample-full.json"),Student.class);
			
			//print first and last name 
			System.out.println("First Name: "+student.getFirstName());
			System.out.println("Last Name: "+student.getLastName());
			System.out.println(student.getAddress());
			for(String s:student.getLanguages()) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
