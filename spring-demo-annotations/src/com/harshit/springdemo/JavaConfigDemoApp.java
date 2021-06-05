package com.harshit.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		//read spring  config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//getbean from spring container
		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		
		//call the method on bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
//		SwimCoach swimcoach=context.getBean("swimCoach",SwimCoach.class);
//		System.out.println(swimcoach.getEmail());
//		System.out.println(swimcoach.getTeam());
		
		
		//close the context
		context.close();
	}

}
