package com.harshit.springboot.cruddemo.service;

import java.util.List;

import com.harshit.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}
