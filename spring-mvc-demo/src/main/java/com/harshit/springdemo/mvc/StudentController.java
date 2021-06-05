package com.harshit.springdemo.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		//create a new student object
		Student student=new Student();
		
		//create that student object to the model attribute
		theModel.addAttribute("student",student);
		theModel.addAttribute("theCountryOptions",countryOptions);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		//log the input data
		System.out.println("thestudent: "+student.getFirstName()+" "+ student.getLastName()+" is from "+student.getCountry());
		System.out.println("his favourite language is "+student.getFavouriteLanguage()+" and uses "+student.getOperatingSystems()[0]);
		return "student-confirmation";
	}
	
}
