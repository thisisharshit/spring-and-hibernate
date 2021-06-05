package com.harshit.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.springboot.cruddemo.entity.Employee;
import com.harshit.springboot.cruddemo.service.EmployeeService;

@RestController
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	//quick and dirty: inject employee dao
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
	// Expose "/employee" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId){
		Employee employee=employeeService.findById(employeeId);
		if(employee==null) {
			throw new RuntimeException("employee id not found - "+employeeId);
		}
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee){
		//also just in case they pass an id in JSON... set id to 0;
		//this is to force 	a save of new item instead of update
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee){
		
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String  deleteEmployee(@PathVariable int employeeId){
		Employee employee=employeeService.findById(employeeId);
		if(employee==null) {
			throw new RuntimeException("employee id not found - "+employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Deleted Employee Id - "+employeeId;
	}
	
	
	
	
	
}
