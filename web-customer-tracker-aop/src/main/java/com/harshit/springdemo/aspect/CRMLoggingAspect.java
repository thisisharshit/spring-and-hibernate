package com.harshit.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup pointcut declarations
	@Pointcut("execution(* com.harshit.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// do the same thing for service and dao package
	@Pointcut("execution(* com.harshit.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.harshit.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		//display method we are calling
		String method=joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> in @Before: calling method: "+method);
		
		//display the arguments of the method
		Object[] args=joinPoint.getArgs();
		for(Object o:args) {
			System.out.println("=====>>>> argument: "+o);
		}
		
	}
	// add @afterReturning advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		//display method we are returning from 
		String method=joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> in @AfterReturning: From method: "+method);
				
		//display the data returned
		System.out.println("=====>>>> result: "+result);
	}
	
}
