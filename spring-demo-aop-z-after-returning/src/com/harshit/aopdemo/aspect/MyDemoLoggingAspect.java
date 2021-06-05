package com.harshit.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
