package com.harshit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	//@Before("execution(public void com.harshit.aopdemo.dao.AccountDAO.addAccount())") //match addAccount method of any class
	//@Before("execution(public void updateAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(* add*())") //modifiers are optional and 1st * means any return type and 2nd * from any method name starting with add
	//@Before("execution(* add*(com.harshit.aopdemo.Account, .. ))") //.. means match any number of arguments after Account param
	//@Before("execution(* add*(..))") //matches any number of params including 0
	
	
	@Before("com.harshit.aopdemo.aspect.AopPointcutExpressions.forDaoPackagenogettersetter()")
	public void beforeAddAccountAdvice() { 
		System.out.println("=====>>>> Executing @Before advice on addAccount()");
	}
	
}
