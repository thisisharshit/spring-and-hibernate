package com.harshit.springdemo;


public class TrackCoach implements Coach{
	
	private FortuneService thefortuneService;
	
	public TrackCoach(FortuneService thefortuneService) {
		this.thefortuneService = thefortuneService;
	}


	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	
	public String getDailyFortune() {
		return "Just Do it! "+thefortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside doMyStartupStuff");
	}
	
	// add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside doMyCleanupStuff");
	}


}
