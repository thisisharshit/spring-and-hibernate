package com.harshit.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	//thats it...no need to write any code LOL!
	
	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc(); 
	//spring data will parse the method name, looks for specific format and pattern, creates appropriate query behind the scenes
		
}
