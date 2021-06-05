package com.harshit.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//ComponentScan("com.harshit.springdemo") dont have to use when using @Bean explicitly below
@PropertySource("classpath:sport.properties")
public class SportConfig {
	//define bean for sad fortune service
	@Bean
	public FortuneService sadFortuneService() { //method name will be the bean id with 1st letter small
		return new SadFortuneService();
	}
	
	//define bean for swimcoach  and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
		
	}
	
}
