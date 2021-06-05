package com.harshit.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.harshit.aopdemo.Account;
@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@After("execution(* com.harshit.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
		//print out which method we are advising on
		String method=joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> Executing @After (Finally) on method: "+method);
						
		
	}
	
	
	@AfterThrowing(
			pointcut = "execution(* com.harshit.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing ="exe")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exe) {
		
		//print out which method we are advising on
		String method=joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> Executing afterThrowing on method: "+method);
						
		//log the exception
		System.out.println("\n=====>>>> The exception is: "+exe);
	}
	
	//add a new advice for @afterReturning on the findAccounts method
	
	@AfterReturning(
			pointcut ="execution(* com.harshit.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")   //returning = parameter name for return value it should match with the argument in below function 
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		
		//print out which method we are advising on 
		String method=joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> Executing afterReturning on method: "+method);
				
		//print out the results of the method call
		System.out.println("\n=====>>>> result is: "+result);
		
		//lets post process the data....lets modify result list: add,remove,update
		
		//conver the account names to uppercase
		convertAccountNamesToUpperCase(result);
		System.out.println("\n=====>>>> result is: "+result);
						
	}
	
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		//loop through accounts
		for(Account temp:result) {
			//get the uppercase version
			String upperCase=temp.getName().toUpperCase();
			//update name of account
			temp.setName(upperCase);
		}
	
	}



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
