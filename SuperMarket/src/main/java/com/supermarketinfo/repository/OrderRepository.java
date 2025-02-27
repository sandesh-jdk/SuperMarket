package com.supermarketinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.supermarketinfo.Entity.CustomerTable;
import com.supermarketinfo.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{		
		@Query("select o from Order o where o.customer=?1")
		public Order getOrderByCustId(CustomerTable cust);
		
		
}
