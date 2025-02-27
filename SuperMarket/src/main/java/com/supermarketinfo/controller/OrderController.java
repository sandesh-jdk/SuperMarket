package com.supermarketinfo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.supermarketinfo.Entity.CustomerTable;
import com.supermarketinfo.Entity.Order;
import com.supermarketinfo.Entity.ProductTable;
import com.supermarketinfo.Entity.Restock;
import com.supermarketinfo.services.CustomerService;
import com.supermarketinfo.services.OrderService;
import com.supermarketinfo.services.ProductService;
import com.supermarketinfo.services.RestockService;

@Controller
public class OrderController 
{		
		@Autowired
		private OrderService orderservice;
		
		@Autowired
		private ProductService productservice;
		
		@Autowired
		private CustomerService customerservice;
		
		@Autowired
		private RestockService restockservice;
		
//		@GetMapping("/allorder")
//		public String getAllCustomer(Model model)
//		{	
//			model.addAttribute("orderlist", orderservice.getAllOrder());
//			return "View_Customer";
//		}
		
		
		@GetMapping("/viewOrder/{id}")
		public String viewOrder(Model model , @PathVariable Long id)
		{	
			CustomerTable cust1=customerservice.getCustomerById(id);
			model.addAttribute("orderlist", orderservice.getOrderByCustId(cust1));
			return "View_Order";
		}
		
		
		@GetMapping("/insertOrder/{id}")
		public String insertOrder(Model model ,@PathVariable Long id)
		{
			Order order=new Order();
			model.addAttribute("order1", order);
			model.addAttribute("allproducts",productservice.getallProducts());
			model.addAttribute("customer",customerservice.getCustomerById(id));
			  
			return"Save_Order";
		}
		
		
		@GetMapping("/saveOrder/{id}")
		public String saveOrder(@ModelAttribute("order1") Order order ,@PathVariable Long id)
		{	
			List<Long> p_id=new ArrayList<Long>();
			for(ProductTable p : order.getProduct1())
			{	
				Long l1=p.getId();
				if(l1!=null)
				{
					p_id.add(l1);
					//System.out.println(l1);
				}
				
			}
			//System.out.println(p_id);
			Integer i=0;
			Integer count =0;
			List<Integer> qty=order.getCust_qty();
			List<ProductTable> pt=productservice.getProductsById(p_id);
			//System.out.println(pt);
			ListIterator <Integer>l1=qty.listIterator();
			while(l1.hasNext())
			{	
				Integer in=l1.next();
				if(in==null)
				{
					l1.remove();
				}
			}
			//System.out.println(qty);
			for(ProductTable p : pt)
			{	
					 i=p.getQuantity()-qty.get(count);
					p.setQuantity(i);	
					//product can be added to restock from here
					if(p.getQuantity()<=4)
					{
						Restock restock=new Restock(p.getId(),p.getBrand(),p.getName(),p.getQuantity());
						restockservice.saveRestock(restock);
					}
					System.out.println(p.getQuantity());
					count ++;
					
			}
		
			//auto ReStock
			
			orderservice.saveOrder(order);
			
			return "redirect:/allcustomer";
		}
		
		
		@GetMapping("/updateOrder/{id}")
		public String updateOrder(Model model , @PathVariable Long id )
		{						

				Order order2=orderservice.getOrderById(id);
				List<Integer> qty=order2.getCust_qty();
				List<Long> p_id=new ArrayList<Long>();
				for(ProductTable p : order2.getProduct1())
				{	
					Long l1=p.getId();
					if(l1!=null)
					{
						p_id.add(l1);
						//System.out.println(l1);
					}
					
				}
				List<ProductTable> pt =productservice.getProductsById(p_id);
				int count=0;
				for(ProductTable p : pt)
				{
					
					p.setQuantity(p.getQuantity()+qty.get(count));
					productservice.saveProduct(p);
					count ++;
					//if customer tries to update the order product can be deleted from restock 
					restockservice.deleterestock(p.getId());
					System.out.println(p.getQuantity());
				}
				model.addAttribute("allproducts",productservice.getallProducts());
				model.addAttribute("customer",customerservice.getCustomerById(id));
				model.addAttribute("updateorder", order2);
				
			return "Update_Order";
		}
		
		@PostMapping("/updatedOrder/{id}")
		public String updatedOrder(@ModelAttribute("updateorder") Order order, @PathVariable Long id)
		{
			order.setOrder_id(id);
			List<Long> p_id=new ArrayList<Long>();
			for(ProductTable p : order.getProduct1())
			{	
				Long l1=p.getId();
				if(l1!=null)
				{
					p_id.add(l1);
				}
				
			}
			Integer i=0;
			Integer count =0;
			List<Integer> qty=order.getCust_qty();
			List<ProductTable> pt=productservice.getProductsById(p_id);
			ListIterator <Integer>l1=qty.listIterator();
			while(l1.hasNext())
			{	
				Integer in=l1.next();
				if(in==null)
				{
					l1.remove();
				}
			}
			for(ProductTable p : pt)
			{	
					 i=p.getQuantity()-qty.get(count);
					 
					p.setQuantity(i);
					if(p.getQuantity()<=4)
					{
						Restock restock=new Restock(p.getId(),p.getBrand(),p.getName(),p.getQuantity());
						restockservice.saveRestock(restock);
					}
					System.out.println(p.getQuantity());
					count ++;
					
			}
			orderservice.saveOrder(order);
			return"redirect:/viewOrder/{id}";
		}
		
		
}
