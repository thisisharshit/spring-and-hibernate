package com.harshit.spring.boot.demo.mycoolappspringboot.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	//expose "/" that returns "Hello World"
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! \nTime on server is "+LocalDateTime.now();
	}
	
	//EXPOSE A NEW ENDPOINT FOR "WORKOUT"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day!";
	}
}
