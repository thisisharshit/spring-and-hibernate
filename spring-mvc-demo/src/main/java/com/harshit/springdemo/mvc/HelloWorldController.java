package com.harshit.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") //parent mapping
public class HelloWorldController {
	
	//need a controller method to show initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//need a controller method to read form data and add data to the model
//	@RequestMapping("/processFormVersionTwo")
//	public String letsShoutDude(HttpServletRequest request,Model model) {
//		
//		//read the request parameter from the html form
//		String name = request.getParameter("studentName");
//		
//		name=name.toUpperCase();
//		
//		String result = "Yo! "+name;
//		
//		//add the message to the model
//		model.addAttribute("message",result); //message is the name, it can be anything
//		
//		return "helloworld";
//	}
	
	@RequestMapping("/processFormVersionTwo")
	public String processFormVersionTwo(
			@RequestParam("studentName") String name,
			Model model) {
		
		name=name.toUpperCase();
		
		String result = "Hey my friend from v2! "+name;
		
		//add the message to the model
		model.addAttribute("message",result); //message is the name, it can be anything
		
		return "helloworld";
	}
}
