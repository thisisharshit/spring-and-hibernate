package com.harshit.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//using pure java configuration

@Configuration 
@EnableAspectJAutoProxy //spring AOP proxy support
@ComponentScan("com.harshit.aopdemo") //Component scans for components and aspects
public class DemoConfig {

	
}
