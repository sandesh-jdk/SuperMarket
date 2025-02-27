package com.supermarketinfo.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.supermarketinfo.Entity.CustomerTable;
import com.supermarketinfo.Entity.Order;
import com.supermarketinfo.services.CustomerService;
import com.supermarketinfo.services.OrderService;
import com.supermarketinfo.services.ProductService;

@Controller
public class CustomerController 
{	
	@Autowired
	private CustomerService custservice;
	@Autowired
	private ProductService proservice;
	@Autowired
	private OrderService orderservice;

	
	@GetMapping("/allcustomer")
	public String getAllCustomer(Model model)
	{	
		model.addAttribute("customerlist", custservice.getAllCustomer());
		
		return "View_Customer";
	}
	
	@GetMapping("/viewcustomer")
	public String viewCustomer()
	{
		return "View_Customer";
	}
//	
	@GetMapping("/insertcustomer")
	public String addCustomer(Model model)
	{	
		CustomerTable customer=new CustomerTable();
		//Order order=new Order();
		model.addAttribute("addcustomer", customer);
		model.addAttribute("allproducts",proservice.getallProducts());
//		model.addAttribute("order1", order);
		return "Save_Customer";
	}
	
	@PostMapping("/savecustomer")
	public String addedCustomer( @ModelAttribute("addcustomer") CustomerTable customer)	
	{			
		
		custservice.saveCustomer(customer);
		//order.setProduct_name(customer.getProduct().get(1).getName());
		
		//orderservice.saveOrder(order);
	
		return"redirect:/allcustomer";
	}
	
	@GetMapping("/updateCustomer/{id}")
	public String updateCustomer(Model model ,@PathVariable Long id)
	{	
		CustomerTable customer=custservice.getCustomerById(id);
		model.addAttribute("updatecustomer", customer);
		return "Update_Customer";
	}
		
	@PostMapping("/updatedCustomer/{id}")
	public String updatedCustomer(@ModelAttribute("updatecustomer") CustomerTable customer ,@PathVariable Long id)
	{	
		customer.setId(id);
		custservice.saveCustomer(customer);
		return "redirect:/allcustomer";
	}
	
	@GetMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable Long id)
	{		
		custservice.deleteCustomer(id);
		return "redirect:/allcustomer";
	}
}
