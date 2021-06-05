package com.harshit.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harshit.aopdemo.dao.AccountDAO;
import com.harshit.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
		//call the business method
		Account account=new Account();
		account.setName("madhu");
		account.setLevel("platinum");
		accountDAO.addAccount(account,true);
		accountDAO.doWork();
		//call the accountdao getter/setter methods
		accountDAO.setName("harshit");
		accountDAO.setServiceCode("silver");
		String name=accountDAO.getName();
		String servicecode=accountDAO.getServiceCode();
		
		membershipDAO.addMembership();
		membershipDAO.goToSleep();
		
		//close the context
		context.close();
		
		
		
		
	}

}