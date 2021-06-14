package com.harshit.springdemo.service;

import java.util.List;

import com.harshit.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers(int sortid);

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomer(String theSearchName);
}
