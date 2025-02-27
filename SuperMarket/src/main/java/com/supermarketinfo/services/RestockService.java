package com.supermarketinfo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarketinfo.Entity.Restock;
import com.supermarketinfo.repository.RestockRepository;

@Service
public class RestockService 
{	
	@Autowired
	private RestockRepository restockRepo;
	
	public List<Restock> getallRestock()
	{
		return restockRepo.findAll();
	}
	
	public Optional<Restock> getRestockById(long id)
	{
		return restockRepo.findById(id);
	}
	
	public void saveRestock(Restock restock)
	{
		restockRepo.save(restock);
	}
	
	public void deleterestock(long id)
	{
		restockRepo.deleteById(id);
	}
}
