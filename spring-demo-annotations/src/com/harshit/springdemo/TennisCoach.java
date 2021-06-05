package com.harshit.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//@Scope("prototype")
@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService; //no need for explicit setter method and constructor
	
	public TennisCoach() {
		System.out.println("tenniscoach: inside default constructor");
	}
	@PostConstruct
	public void domystartstuff() {
		System.out.println("tenniscoach: inside domystartupstuff");
	}
	
	@PreDestroy
	public void domycleanupstuff() {
		System.out.println("tenniscoach: inside domycleanupstuff");
	}
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println("tennisCoach: inside setfortuneservice method");
//		this.fortuneService = fortuneService;
//	}
//	
//	@Autowired
//	public void dosomecrazystuff(FortuneService fortuneService) {
//		System.out.println("tennisCoach: inside DOSOMECRAZYSTUFF method");
//		this.fortuneService = fortuneService;
//	}
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override 	
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}	
}
