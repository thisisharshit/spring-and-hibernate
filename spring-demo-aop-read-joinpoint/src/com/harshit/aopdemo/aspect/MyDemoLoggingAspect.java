package com.harshit.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.harshit.aopdemo.Account;
import com.harshit.aopdemo.dao.AccountDAO;

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
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) { //joinpoint hold the metadata about the class function
		System.out.println("=====>>>> Executing @Before advice on addAccount()");
		
		//display the method signature
		MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: "+methodSignature);
		
		//display the method arguments
		Object[] args=theJoinPoint.getArgs(); //getting the arguments
		for(Object o:args) {
			System.out.println(o);
			if(o instanceof Account) {
				//downcast and print account specific stuff
				Account account=(Account)o;
				System.out.println("the account name: "+account.getName());
				System.out.println("the account level: "+account.getLevel());
			}
		}
	}
	
}
