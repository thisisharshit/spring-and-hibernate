package com.harshit.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	//thats it...no need to write any code LOL!
}
