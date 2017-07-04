package com.bix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bix.services.BranchService;

@Controller
public class BranchController {
	
	
	@Autowired BranchService branchService;
	
	
	@RequestMapping("/")
	public String home() {
		
		System.out.println("In home method ... ");
	        return "index";
	}
	
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String showWelcome()
	{
		
		System.out.println("In Show Weocme method");
		
		branchService.getDBDate();
		
		
		return "index";
		
		
	}
	
	

}
