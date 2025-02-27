package com.supermarketinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.supermarketinfo.Entity.CustomerTable;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerTable,Long>
{
	@Query("select c from CustomerTable c where c.date_of_order = ?1")
	public List<CustomerTable> getCustomerbyDate(String date);
	
	@Query("select c from CustomerTable c where c.date_of_order between ?1 and ?2")
	public List<CustomerTable> getcustbetweenDate(String date, String tdate);
}
