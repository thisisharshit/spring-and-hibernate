package com.harshit.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harshit.springboot.thymeleafdemo.entity.Employee;
import com.harshit.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Autowired // this is optional since we have only one constructor
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	// add mapping for /list
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		//get employees from db
		List<Employee> theEmployees=employeeService.findAll();
		
		theModel.addAttribute("employees",theEmployees);
		return "list-employees";
	}
	
}
