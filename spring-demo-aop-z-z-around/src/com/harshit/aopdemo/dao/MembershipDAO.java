package com.harshit.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public int addMembership() {
		System.out.println(getClass()+": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		return 0;
	}
	
	public void goToSleep() {
		System.out.println(getClass()+": I'm going to sleep now ...");
	}
	
}
