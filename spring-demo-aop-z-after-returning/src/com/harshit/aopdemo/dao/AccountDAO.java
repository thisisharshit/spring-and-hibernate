package com.harshit.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.harshit.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name,serviceCode;
	
	
	//add a new method: findAccounts()
	public List<Account> findAccounts(){
		List<Account> myAccounts=new ArrayList<Account>();
		//create some sample acccounts
		Account a1=new Account("John", "Silver");
		Account a2=new Account("Madhu","Platinum");
		Account a3=new Account("Luca", "Gold");
		//add them to our accounts list
		myAccounts.add(a1);
		myAccounts.add(a2);
		myAccounts.add(a3);
		
		//add them to our accounts list
		
		return myAccounts;
	}
	
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
