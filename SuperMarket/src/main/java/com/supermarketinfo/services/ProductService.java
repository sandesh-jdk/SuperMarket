package com.supermarketinfo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarketinfo.Entity.ProductTable;
import com.supermarketinfo.repository.ProductRepository;

@Service
public class ProductService 
{		
		@Autowired
		private ProductRepository productrepo;
		
		public List<ProductTable> getallProducts()
		{
			return productrepo.findAll();
		}
		
		public Optional<ProductTable> getProductByid(Long id)
		{
			return Optional.ofNullable(productrepo.findById(id).orElseThrow());
		//	return productrepo.findById(id);
		}
		
		 public List<ProductTable> getProductsById(List<Long> ids) 
		 {
		        return productrepo.findAllById(ids);
		    }
		
		public void saveProduct(ProductTable product)
		{
			productrepo.save(product);
		}
		
		public void deleteProduct(long id)
		{
			productrepo.deleteById(id);
		}
		
		public ProductTable updateQty(Long id)
		{
			return productrepo.updateQty(id);
		}
}
