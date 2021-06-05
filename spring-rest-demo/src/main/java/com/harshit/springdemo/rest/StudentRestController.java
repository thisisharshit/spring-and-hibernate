package com.harshit.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;
	
	//define @postconstruct to load the student data.. only once
	@PostConstruct
	public void loadData() {
		students=new ArrayList<Student>();
		students.add(new Student("poornima","patel"));
		students.add(new Student("Mario","Rossi"));
		students.add(new Student("mary","smith"));
		
	}
	
	
	//deifne an endpoint for /students - return list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return students;
	}
	@GetMapping("/students/{studentId}")
	public  Student getStudents(@PathVariable int studentId){
		
		if(studentId>=students.size() || studentId<0) {
			throw new StudentNotFoundException("Student id not found - "+studentId);
		}
		
		return students.get(studentId);
	}
	
	
}
