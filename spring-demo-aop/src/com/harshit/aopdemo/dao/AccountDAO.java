package com.harshit.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.harshit.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account account, boolean flag) {
		System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	public boolean doWork() {
		System.out.println(getClass()+": doWork()");
		return false;
	}
}
