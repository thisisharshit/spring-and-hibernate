package com.harshit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	//@Before("execution(public void com.harshit.aopdemo.dao.AccountDAO.addAccount())") //match addAccount method of any class
	//@Before("execution(public void updateAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(* add*())") //modifiers are optional and 1st * means any return type and 2nd * from any method name starting with add
	//@Before("execution(* add*(com.harshit.aopdemo.Account, .. ))") //.. means match any number of arguments after Account param
	//@Before("execution(* add*(..))") //matches any number of params including 0
	
	@Pointcut("execution(* com.harshit.aopdemo.dao.*.*(..))") //now we can use this on multiple advices using below function name
	private void forDaoPackage() {}
	
	//create pointcut method for getter methods
	@Pointcut("execution(* com.harshit.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	//create pointcut method for setter methods
	@Pointcut("execution(* com.harshit.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	//create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackagenogettersetter() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() { 
		System.out.println("\n=====>>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackagenogettersetter()")
	public void performApiAnalytics() {
		System.out.println("=====>>>> Performing API Analytics");
	}
	
	
}
