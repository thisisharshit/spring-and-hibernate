package com.harshit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointcutExpressions {
	
	@Pointcut("execution(* com.harshit.aopdemo.dao.*.*(..))") //now we can use this on multiple advices using below function name
	public void forDaoPackage() {}
	
	//create pointcut method for getter methods
	@Pointcut("execution(* com.harshit.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	//create pointcut method for setter methods
	@Pointcut("execution(* com.harshit.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackagenogettersetter() {}
}
