package com.harshit.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.harshit.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name,serviceCode;
	
	public String getName() {
		System.out.println(getClass()+": getName()");
		return name;
	}
	public void setName(String name) {
		System.out.println(getClass()+": setName()");
		this.name = name;
	}
	public String getServiceCode() {
		System.out.println(getClass()+": getServiceCode()");
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": setServiceCode()");
		this.serviceCode = serviceCode;
	}
	public void addAccount(Account account, boolean flag) {
		System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	public boolean doWork() {
		System.out.println(getClass()+": doWork()");
		return false;
	}
}
