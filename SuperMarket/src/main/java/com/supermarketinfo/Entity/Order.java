package com.supermarketinfo.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Order_Table")
public class Order 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_id;
	@ManyToMany
	@JoinTable(
				name="order_prod_relation",
				joinColumns = {@JoinColumn(name="order_id")},
				inverseJoinColumns = {@JoinColumn(name="prod_id")}
			)
	private List<ProductTable> product1;
	@ElementCollection //it will create a separate table for cust_qty and will map it with order id like(one to many relationship)
	private List<Integer> cust_qty;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="Customer_id")
	private CustomerTable customer;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Order(long order_id, List<ProductTable> product1, List<Integer> cust_qty, CustomerTable customer) {
		super();
		this.order_id = order_id;
		this.product1 = product1;
		this.cust_qty = cust_qty;
		this.customer = customer;
	}



	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public List<ProductTable> getProduct1() {
		return product1;
	}

	public void setProduct1(List<ProductTable> product1) {
		this.product1 = product1;
	}

	public List<Integer> getCust_qty() {
		return cust_qty;
	}

	public void setCust_qty(List<Integer> cust_qty) {
		this.cust_qty = cust_qty;
	}



	public CustomerTable getCustomer() {
		return customer;
	}



	public void setCustomer(CustomerTable customer) {
		this.customer = customer;
	}



//	public String toString()
//	{
//		return String.valueOf(order_id);
//	}
	
	
	
}
