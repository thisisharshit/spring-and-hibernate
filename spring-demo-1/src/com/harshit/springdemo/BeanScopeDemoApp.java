package com.harshit.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beanscope-applicationContext2.xml");
		
		Coach theCoach=context.getBean("myCoach",Coach.class);
		
		Coach alphaCoach=context.getBean("myCoach",Coach.class);
		
		boolean result=theCoach==alphaCoach;
		
		System.out.println("pointing to the same object: "+result);

		System.out.println("memory location of the theCoach: "+theCoach);
		System.out.println("memory location of the aphaCoach: "+alphaCoach+"\n");
	}
}
