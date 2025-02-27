package com.supermarketinfo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.supermarketinfo.Entity.RegistrationTable;
import com.supermarketinfo.services.RegisService;

import jakarta.servlet.http.HttpSession;


@Controller
public class FirstController
{		
		@Autowired
		private RegisService regiservice;
	
	@GetMapping("/")
	public String FirstPage(Model model)
	{	
		RegistrationTable registrationTable=new RegistrationTable();
		
		model.addAttribute("login", registrationTable);
		
		return"LoginPage";
	}
	
	
	@GetMapping("/login")
	public String LoginPage(@ModelAttribute("login1") RegistrationTable rt)
	{	 

		regiservice.save(rt);
		
		return "redirect:/";
	}
		@GetMapping("/register")
		public String RegistrationPage(Model model)
		{	
			RegistrationTable registrationTable=new RegistrationTable();
			model.addAttribute("login1", registrationTable);
			return "RegistrationPage";
		}
		
		@PostMapping("/dashboard")
		public String dashBoard(@ModelAttribute("login") RegistrationTable table )
		{		
			Long uid=table.getU_id();
			String pass=table.getPassword();
			Long f_id;
			
			if((f_id=regiservice.getuserid(uid))==null)
			{
				f_id=0l;
			}
			String f_pass=regiservice.getpassword(uid);
		
			
			if(f_id.equals(uid) && f_pass.equals(pass))
			{	
				
				return "Dashboard";
			}
			else
			{
				return "ErrorPage";
			}
			
		}
		
		@GetMapping("/dash")
		public String dash()
		{
			return "Dashboard";
		}
		
		@GetMapping("/errorpage")
		public String ErrorPAge(Model model)
		{
			RegistrationTable table = new RegistrationTable();
			model.addAttribute("login", table);
			return "redirect:/dashboard";
		}
}
