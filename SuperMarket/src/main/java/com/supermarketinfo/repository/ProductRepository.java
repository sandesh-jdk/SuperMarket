package com.supermarketinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.supermarketinfo.Entity.ProductTable;


@Repository
public interface ProductRepository extends JpaRepository<ProductTable, Long> 
{	
	@Query("update ProductTable p set p.quantity=p.quantity-(select o.cust_qty from Order o where o.order_id=?1) "
			+ "where p.id=(select o.order_id from Order o where o.order_id=?1)")
	public ProductTable updateQty(long id);
	
	
}


//update product_table set qty=qty-(select cust_qty from order_cust_qty where order_order_id=
//(select order_id from order_table where order_id=1)) where id=(select order_id from order_prod_relation where order_id=1)