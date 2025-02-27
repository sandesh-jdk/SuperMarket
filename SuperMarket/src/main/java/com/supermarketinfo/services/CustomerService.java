package com.supermarketinfo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarketinfo.Entity.CustomerTable;
import com.supermarketinfo.repository.CustomerRepository;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepository custrepo;
	
	public List<CustomerTable> getAllCustomer()
	{
		return custrepo.findAll();
	}
	
	public CustomerTable getCustomerById(Long id)
	{
		return custrepo.findById(id).orElseThrow();
	}
	
	public List<CustomerTable> getCustomerbyDate(String date)
	{
		return custrepo.getCustomerbyDate(date);
	}
	
	public List<CustomerTable> getcustbetweenDate(String date , String tdate)
	{
		return custrepo.getcustbetweenDate(date, tdate);
	}
	
	public void saveCustomer(CustomerTable customer)
	{
		custrepo.save(customer);
	}
	
	public void deleteCustomer(Long id)
	{
		custrepo.deleteById(id);
	}
}
