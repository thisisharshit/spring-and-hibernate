package com.harshit.spring.boot.demo.mycoolappspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //this does enable auto config, component scanning, additional config
public class MycoolappspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappspringbootApplication.class, args);
	}

}
