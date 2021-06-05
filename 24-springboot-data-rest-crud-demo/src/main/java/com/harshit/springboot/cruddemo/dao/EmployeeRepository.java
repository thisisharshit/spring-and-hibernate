package com.harshit.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.harshit.springboot.cruddemo.entity.Employee;

@RepositoryRestResource(path = "members") //default path is entity name with 1st letter lowercase + s = empployees in this case
//we can change this /employees using above annotation
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	//thats it...no need to write any code LOL!
}
