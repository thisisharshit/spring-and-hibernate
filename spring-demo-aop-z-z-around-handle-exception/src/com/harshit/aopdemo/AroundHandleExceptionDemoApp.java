package com.harshit.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harshit.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("\nMain Program: AroundHandleExceptionDemoApp");
		System.out.println("calling getfortune");
			
		boolean tripWire=true;
		String data=theFortuneService.getFortune(tripWire);
		System.out.println("\nMy fortune is: "+data);
		System.out.println("finished");
		
		//close the context
		context.close();
		
		
		
		
	}

}
