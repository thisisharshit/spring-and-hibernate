package com.harshit.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	private String[] arr= {"this is your 1st day",
			"this is your 2nd day",
			"this is your 3rd day"
	};
	private Random random=new Random();
	@Override
	public String getFortune() {
		
		return arr[random.nextInt(3)];
		
	}
	
}
