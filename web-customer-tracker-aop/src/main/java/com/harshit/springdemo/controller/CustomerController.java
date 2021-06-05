package com.harshit.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshit.springdemo.entity.Customer;
import com.harshit.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/*//need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO; //spring will look for components that implements CustomerDAO interface
	*/ // removing this because of service layer
	
	//need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get Customers from the dao
		List<Customer> thecustomers=customerService.getCustomers();
		
		//add those customers to my spring mvc model
		theModel.addAttribute("customers",thecustomers);		
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model theModel) {
		//create model attribute to bind the form data
		Customer thecustomer=new Customer();
		
		theModel.addAttribute("customer",thecustomer);
		                //attribute name//attribute value
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")  //<form:form action="saveCustomer" modelAttribute="customer" methos="POST">
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel) {
		//get the customer from our service
		Customer theCustomer=customerService.getCustomers(id);
		//set the customer as model attribute to prepopulate the form
		theModel.addAttribute("customer",theCustomer);
		//send over to our form
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		//delete the customer
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
	
}
