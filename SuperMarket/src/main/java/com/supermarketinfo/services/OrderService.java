package com.supermarketinfo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarketinfo.Entity.CustomerTable;
import com.supermarketinfo.Entity.Order;
import com.supermarketinfo.repository.OrderRepository;

@Service
public class OrderService
{	
		@Autowired
		private OrderRepository orderRepo;
		
		public List<Order> getAllOrder()
		{
			return orderRepo.findAll();
		}
		
		public Order getOrderById(Long id)
		{
			return orderRepo.findById(id).orElseThrow();
		}
		
		public List<Order> getOrderByCustIds(List<Long> c_id)
		{
			return orderRepo.findAllById(c_id);
		}
		
		public void saveOrder(Order order)
		{
			orderRepo.save(order);
		}
		
		public void deleteOrder(Long id)
		{
			orderRepo.deleteById(id);
		}
		
		public Order getOrderByCustId(CustomerTable cust)
		{
			return orderRepo.getOrderByCustId(cust);
		}
}
