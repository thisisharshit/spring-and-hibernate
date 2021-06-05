package com.harshit.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harshit.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	private List<Employee> theEmployees;
	
	@PostConstruct
	public void loadData() {
		//create employees
		Employee e1=new Employee(1,"Harshit","Agarwal","harshit@gmail.com");
		Employee e2=new Employee(1,"Divyansh","Garg","divyansh@gmail.com");
		Employee e3=new Employee(1,"Yash","Sahu","yash@gmail.com");
		
		//create the list
		theEmployees=new ArrayList<Employee>();
		
		//add to the list
		theEmployees.add(e1);
		theEmployees.add(e2);
		theEmployees.add(e3);
	}
	
	// add mapping for /list
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees",theEmployees);
		return "list-employees";
	}
	
}
