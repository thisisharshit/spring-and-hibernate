package com.harshit.springdemo;

public class MyApp {

	public static void main(String[] args) {
//		Coach baseballCoach=new BaseballCoach();
//		Coach theCoach=new BaseballCoach();

		Coach theCoach=new TrackCoach(new HappyFortuneService());
		System.out.println(theCoach.getDailyFortune());
	}
}
