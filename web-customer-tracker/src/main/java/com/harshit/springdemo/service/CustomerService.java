package com.harshit.springdemo.service;

import java.util.List;

import com.harshit.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int id);

	public void deleteCustomer(int id);
}
