package com.harshit.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load spring config file
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from container
		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		Coach alphaCoach=context.getBean("tennisCoach",Coach.class);
		
		boolean result=theCoach==alphaCoach;
		
		System.out.println("pointing to the same object: "+result);
		System.out.println("memory location for theCoach: "+theCoach);
		System.out.println("memory location for alphaCoach: "+alphaCoach);
		
		
		context.close();
	}

}
