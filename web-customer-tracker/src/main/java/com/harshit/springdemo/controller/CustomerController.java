package com.harshit.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshit.springdemo.entity.Customer;
import com.harshit.springdemo.service.CustomerService;
import com.harshit.springdemo.sorting.SortUtils;

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
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true); // defined in spring api
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/list")
	public String listCustomers(Model theModel, @RequestParam(required = false) String sort) {
		
		//get Customers from the service
		List<Customer> thecustomers=null;
		
		if(sort!=null) {
			int sortid = Integer.parseInt(sort);
			thecustomers=customerService.getCustomers(sortid);
		}
		else {
			thecustomers=customerService.getCustomers(SortUtils.LAST_NAME);
		}
		
		
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
	
	@PostMapping("/saveCustomer")  //<form:form action="saveCustomer" modelAttribute="customer" method="POST">
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer ,
			BindingResult br) {
		
		System.out.println("Binding Result: "+br);
		
		if(br.hasErrors()) {
			return "customer-form";
		}
		//save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel) {
		//get the customer from our service
		Customer theCustomer=customerService.getCustomer(id);
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
	
	
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String theSearchName,Model theModel) {
		//search customers from the service
		List<Customer> customers = customerService.searchCustomer(theSearchName);
		
		//add the customers to the model
		theModel.addAttribute("customers",customers);
		
		return "list-customers";
	}
	
}
