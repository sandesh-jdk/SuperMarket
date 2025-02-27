package com.supermarketinfo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.supermarketinfo.Entity.CustomerTable;
import com.supermarketinfo.Entity.Order;
import com.supermarketinfo.Entity.ProductTable;
import com.supermarketinfo.services.CustomerService;
import com.supermarketinfo.services.OrderService;

@Controller
public class NetProfitController {
	@Autowired
	private CustomerService customerservice;

	@Autowired
	private OrderService orderservice;

	@GetMapping("/netprofit")
	public String viewnetProfit(Model model) {
		LocalDate today = LocalDate.now();
		String date = String.valueOf(today);

		List<Long> c_id = new ArrayList<Long>();
		for (CustomerTable c : customerservice.getCustomerbyDate(date))// Fetching customer on the basis of current
																		// date.
		{
			c_id.add(c.getId());
		}

		List<Order> orders = orderservice.getOrderByCustIds(c_id);//[1,2,3]
		List<Long> total = new ArrayList<Long>();
		for (Order o : orders) {
			List<ProductTable> pt = o.getProduct1();

			
			 if (!pt.isEmpty() && !o.getCust_qty().isEmpty()) 
			 { 
				 for (int i = 0; i <pt.size() && i < o.getCust_qty().size(); i++) 
				 {
				  total.add((pt.get(i).getSelling_price() - pt.get(i).getPurchase_price()) *
				  o.getCust_qty().get(i)); 
				 }
			 } 
			 else { 
				 System.out.println("Skipping order due to empty product list or quantity list."); 
				 }
			 

//				System.out.println("Selling Price"+pt.get(count).getSelling_price());
//				System.out.println("Cost Price"+pt.get(count).getPurchase_price());
//				System.out.println("Cust Qty"+o.getCust_qty().get(count));
//				System.out.println(total);
//				
			 }
			System.out.println("total list"+total);
			
			long sum=0;
			for(Long l : total)
			{
				sum = sum+l;
			}
			System.out.println("Total of profit list is "+sum);
		model.addAttribute("netprofit", orders);
		model.addAttribute("dates", date);
		model.addAttribute("totals", sum);
		// model.addAttribute("totals", total);

		return "View_NetProfit";
	}
		
		@GetMapping("/profitByDates")
		public String netProfitByDates(@RequestParam("fdate") String date , @RequestParam("todate") String tdate , Model model)
		{	
			List<Long> c_id = new ArrayList<Long>();
			for(CustomerTable c : customerservice.getcustbetweenDate(date, tdate))
			{
				c_id.add(c.getId());
			}
			
			List<Order> orders = orderservice.getOrderByCustIds(c_id);
			List<Long> total = new ArrayList<Long>();
			for (Order o : orders) {
				List<ProductTable> pt = o.getProduct1();

				
				 if (!pt.isEmpty() && !o.getCust_qty().isEmpty()) 
				 { 
					 for (int i = 0; i <pt.size() && i < o.getCust_qty().size(); i++) 
					 {
					  total.add((pt.get(i).getSelling_price() - pt.get(i).getPurchase_price()) *
					  o.getCust_qty().get(i)); 
					 }
				 } 
				 else { 
					 System.out.println("Skipping order due to empty product list or quantity list."); 
					 }
			}
			long sum=0;
			for(Long l : total)
			{
				sum = sum+l;
			}
			model.addAttribute("profit", orders);
			model.addAttribute("date",customerservice.getcustbetweenDate(date, tdate));
			model.addAttribute("totals", sum);
			return "View_NetProfit2";
		}
}
