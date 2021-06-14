package com.harshit.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication // this annotation eq to @configuration @componentscan, @Enableautoconfiguration
@Configuration
@ComponentScan(basePackages = "com.harshit.springboot")
@EnableAutoConfiguration
public class SipCalculatorApplication {
	
	/*
	@ResponseBody //spring will directly put the response back in http response and will not return view
	@RequestMapping("/") 
	public String entry() {
		return "My Spring Boot App";
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(SipCalculatorApplication.class, args);
	}

}
