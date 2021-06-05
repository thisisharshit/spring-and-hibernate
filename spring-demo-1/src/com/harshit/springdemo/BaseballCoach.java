package com.harshit.springdemo;

public class BaseballCoach implements Coach{

	
	//define a private field for the dependency
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService ) {
		fortuneService=theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "do cardio for 30 minutes";
	}


	public String getDailyFortune() {
		return fortuneService.getFortune();
		
	}

	
}
