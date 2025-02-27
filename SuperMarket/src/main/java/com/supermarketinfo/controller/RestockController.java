package com.supermarketinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.supermarketinfo.Entity.ProductTable;
import com.supermarketinfo.Entity.Restock;
import com.supermarketinfo.services.ProductService;
import com.supermarketinfo.services.RestockService;

@Controller
public class RestockController
{	
	@Autowired
	private RestockService restockservice;
	
	@Autowired
	private ProductService proservice;
	
	@GetMapping("/allrestock")
	public String getallRestock(Model model)
	{	
		Restock restock = new Restock();
		model.addAttribute("updatedrestock", restock);
		model.addAttribute("allrestock",restockservice.getallRestock());
		
		
		return "View_Restock";
	}
	
	@GetMapping("/saverestock/{id}")
	public String saveRestock( @PathVariable Long id )
	{	
		ProductTable product=proservice.getProductByid(id).orElseThrow();
		Restock restock=new Restock(product.getId(),product.getBrand(),product.getName(),product.getQuantity());
		restockservice.saveRestock(restock);
		return "redirect:/allproducts";
	}
	
	@GetMapping("/updatedrestock/{id}")
	public String updatedrestock(@PathVariable Long id,@ModelAttribute ("updatedrestock")Restock restock)
	{	
		ProductTable product = proservice.getProductByid(id).orElseThrow();
		System.out.println(restock.getR_quantity());
		product.setQuantity(product.getQuantity()+restock.getR_quantity());
		proservice.saveProduct(product);
		
		restockservice.deleterestock(id);

		return"redirect:/allrestock";
	}
	
	@GetMapping("/deleterestock/{id}")
	public String deleterestock(@PathVariable Long id)
	{
		restockservice.deleterestock(id);
		
		
		return "redirect:/allrestock";
	}
	
	
}


