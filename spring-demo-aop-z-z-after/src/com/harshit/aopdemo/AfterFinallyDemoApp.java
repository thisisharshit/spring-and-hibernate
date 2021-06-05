package com.harshit.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harshit.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call the method to find the accounts
		List<Account> theAccounts=null;
		try {
			//add a boolean flag to simulate an exception
			boolean tripWire=false;
			theAccounts=accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program caught exception: "+e);
		}
		
		
		//display the accounts
		System.out.println("\n\nMainProgram: After Finally Demo App");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		//close the context
		context.close();
		
		
		
		
	}

}
