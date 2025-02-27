package com.supermarketinfo.Entity;

import java.util.List; 

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Product_Table")
public class ProductTable
{		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(name="Name")
		private String name;
		@Column(name="Brand")
		private String brand;
		@Column(name="Qty")
		private int quantity;
		@Column(name="Selling_Price")
		private long selling_price;
		@Column(name="Purchase_Price")
		private long purchase_price;
//		@ManyToMany(mappedBy = "product")
//		private List<CustomerTable> customer;
		@ManyToMany(mappedBy = "product1")
		private List<Order> order;
		
		public ProductTable() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		

		public ProductTable(long id, String name, String brand, int quantity, long selling_price, long purchase_price, 
				List<Order> order) {
			super();
			this.id = id;
			this.name = name;
			this.brand = brand;
			this.quantity = quantity;
			this.selling_price = selling_price;
			this.purchase_price = purchase_price;
			//this.customer = customer;
			this.order = order;
		}




		public long getId() {
			return id;
		}




		public void setId(long id) {
			this.id = id;
		}




		public String getName() {
			return name;
		}




		public void setName(String name) {
			this.name = name;
		}




		public String getBrand() {
			return brand;
		}




		public void setBrand(String brand) {
			this.brand = brand;
		}




		public int getQuantity() {
			return quantity;
		}




		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}




		



		public long getSelling_price() {
			return selling_price;
		}




		public void setSelling_price(long selling_price) {
			this.selling_price = selling_price;
		}




		public long getPurchase_price() {
			return purchase_price;
		}




		public void setPurchase_price(long purchase_price) {
			this.purchase_price = purchase_price;
		}




//		public List<CustomerTable> getCustomer() {
//			return customer;
//		}
//
//
//
//
//		public void setCustomer(List<CustomerTable> customer) {
//			this.customer = customer;
//		}




		public List<Order> getOrder() {
			return order;
		}




		public void setOrder(List<Order> order) {
			this.order = order;
		}




		@Override
		public String toString() {
			return String.valueOf(id)+" "+String.valueOf(quantity);
		}




		
		
		
}
