package com.harshit.springboot.controller;

import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.harshit.springboot.entity.Data;

@Controller
public class DemoController {
	
	
	@RequestMapping("/") 
	public String entry() {
		return "home";
	}
	
	@GetMapping("/sipcalculator")
	public String SIPCalculator(Model model) {
		model.addAttribute("data", new Data());
		return "sipcalculator";
	}
	
	@GetMapping("/goalsipcalculator")
	public String goalSIPCalculator() {
		return "goalsipcalculator";
	}

	
	@PostMapping("/calculatesip")
	public String CalculateSIPReturns(@ModelAttribute("data") Data data,
			Model model) {
		
		int amt  = data.getPrincipalAmt();
		double rate = (double)data.getRateOfReturn();
		double inc = (double)data.getIncrement();
		int years = data.getYears();
		
		rate=rate/100.0 + 1.0;
		inc = inc/100.0;
		double result=0;
		double newamt=amt;
		double totalInvestment=0;
		for(int i=years;i>0;i--) {
			result+=(Math.pow(rate, (double)(i)))*newamt;
			totalInvestment+=newamt;
			newamt = newamt+newamt*inc;
			
		}
		Locale india = new Locale("hi","IN");
		NumberFormat formatter = NumberFormat.getCurrencyInstance(india);
	
		String ans = formatter.format(result);
		String total = formatter.format(totalInvestment);
		
		
		model.addAttribute("result", ans);
		model.addAttribute("total", total);
		
		return "sipreturns";
	}
	
	@PostMapping("/calculategoalsip")
	public String CalculateGoalSIPReturns() {
		return "redirect:/goalsipcalculator";
	}
	
	
	
	
}
