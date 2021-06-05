package com.harshit.springdemo;

public class CricketCoach implements Coach {
	
	
	private FortuneService thefortuneService;
	private String emailAdd;
	private String team;
	
	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		System.out.println("inside the setter method - setemailadd");
		this.emailAdd = emailAdd;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("inside the setter method - seteam");
		this.team = team;
	}

	public void setThefortuneService(FortuneService thefortuneService) {
		System.out.println("inside the setter method - setfortuneservice");
		this.thefortuneService = thefortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return thefortuneService.getFortune();
	}
}
