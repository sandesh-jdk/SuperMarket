package com.supermarketinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.supermarketinfo.Entity.DuplicateExceptionClass;
import com.supermarketinfo.Entity.ProductTable;
import com.supermarketinfo.services.ProductService;




@Controller
public class ProductController 
{	
	@Autowired
	private ProductService proservice;
	
	@GetMapping("/allproducts")
	public String getallProduct(Model model)
	{	
		model.addAttribute("getproduct",  proservice.getallProducts());
		return "AllProduct";
	}
	
	@GetMapping("/product")
	public String insertProduct( Model model)
	{	
		ProductTable product1=new ProductTable();
		model.addAttribute("product", product1);
		return "SaveProduct";
	}
	
	
	@PostMapping("/saveProduct")
	public String save( @ModelAttribute("product") ProductTable pro) throws DuplicateExceptionClass
	{	
		boolean Duplicate = false;

		for (ProductTable p : proservice.getallProducts())
		{
		    if (p.getName().equals(pro.getName()))
		    {  	
		    	Duplicate = true; 
		    	
		       throw new DuplicateExceptionClass("Duplicate Product Name");
		      
		         
		    }
		}

		
		if (Duplicate==false) {
		    proservice.saveProduct(pro);
		}

		
		
		return"redirect:/allproducts";
	}
	
	@GetMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable Long id)
	{	
		proservice.deleteProduct(id);
		return "redirect:/allproducts";
	}
	
	@GetMapping("/updateproduct/{id}")
	public String updateProduct(@PathVariable Long id ,Model model)
	{	
		ProductTable product =proservice.getProductByid(id).orElseThrow();
		model.addAttribute("updateProduct", product);
		return"Update_Product";
	}
	
	@PostMapping("/updatedproduct/{id}")
	public String updatedproduct(@PathVariable Long id , ProductTable product) 
	{	
		

		
		
			
			ProductTable product1 = proservice.getProductByid(id).orElseThrow();
			product.setId(id);
			product.setQuantity(product1.getQuantity());
			proservice.saveProduct(product);
		
			
		return"redirect:/allproducts";
	}
	
	
}
