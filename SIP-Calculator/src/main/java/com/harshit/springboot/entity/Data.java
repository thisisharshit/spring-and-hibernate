package com.harshit.springboot.entity;

public class Data {
	private int principalAmt;
	
	private int rateOfReturn;
	
	private int increment;
	
	private int years;
	
	public Data() {
		
	}

	public Data(int principalAmt, int rateOfReturn, int increment, int years) {
		this.principalAmt = principalAmt;
		this.rateOfReturn = rateOfReturn;
		this.increment=increment;
		this.years = years;
	}

	public int getIncrement() {
		return increment;
	}

	public void setIncrement(int increment) {
		this.increment = increment;
	}

	public int getPrincipalAmt() {
		return principalAmt;
	}

	public void setPrincipalAmt(int principalAmt) {
		this.principalAmt = principalAmt;
	}

	public int getRateOfReturn() {
		return rateOfReturn;
	}

	public void setRateOfReturn(int rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}
	
}
