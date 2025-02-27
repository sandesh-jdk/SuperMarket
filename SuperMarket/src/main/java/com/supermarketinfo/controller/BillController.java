package com.supermarketinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.supermarketinfo.Entity.Order;
import com.supermarketinfo.Entity.ProductTable;
import com.supermarketinfo.services.CustomerService;
import com.supermarketinfo.services.OrderService;

@Controller
public class BillController 
{	
		@Autowired
		private CustomerService custservice;
		
		@Autowired
		private OrderService orderservice;
	
	@GetMapping("/bill/{id}")
	public String billGenerate(@PathVariable Long id,Model model)
	{	
		Order orders = orderservice.getOrderById(id);
		model.addAttribute("custname",custservice.getCustomerById(id));
		model.addAttribute("order",orders);
		int count=0;
		long sum=0;
		for(ProductTable p : orders.getProduct1() )
		{	
			if(orders.getCust_qty().get(count)!=null)
			{
			sum+=(p.getSelling_price()*orders.getCust_qty().get(count));
			}
			count ++;
		}
		
		model.addAttribute("total",sum);
		
		return "View_Bill";
	}
}
