package com.harshit.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshit.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.harshit.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}

	//jpa repository provides @transactional service
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		//optional is diff pattern, instead of writing code to check for null we can use optional
		Employee employee=null;
		if(result.isPresent()) {
			employee=result.get();
		}
		else {
			//we didnt find the employee
			throw new RuntimeException("Did not find employee id of "+id);
		}
		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
