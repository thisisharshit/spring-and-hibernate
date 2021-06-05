package com.harshit.springsecurity.demo.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.harshit.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties") //will read the props file, src/main/resources files are automatically added to the classpath during maven build
public class DemoAppConfig {
	
	// set up a variable to hold the properties
	
	@Autowired
	private Environment env; //this will hold the data read from properties file  
	
	
	//define a bean for viewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	// define a bean for our security datasource
	@Bean
	public DataSource securityDataSource() {
		//create the connection pool
		ComboPooledDataSource securityDataSource=new ComboPooledDataSource();
		
		//set the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {	
			throw new RuntimeException(e);
		}
		
		//log the connection props
		System.out.println(">>> jdbc.url="+env.getProperty("jdbc.url"));
		System.out.println(">>> jdbc.user="+env.getProperty("jdbc.user"));
		
		//set the connection data properties
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//set connection pool properties
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	
	//need a helper method
	//read env property  and convert to int
	
	private int getIntProperty(String p) {
		String propval=env.getProperty(p);
		int propvalint=Integer.parseInt(propval);
		return propvalint;
	}
	
	
	
	
}
