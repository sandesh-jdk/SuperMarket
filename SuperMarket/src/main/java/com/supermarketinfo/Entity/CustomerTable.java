package com.supermarketinfo.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer_Table")
public class CustomerTable 
{		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(name="Customer_Name")
		private String name;
		@Column(name="Mobile_Number")
		private long mobile_number;
		@Column(name="Date")
		private String  date_of_order;
		
		@OneToOne(mappedBy = "customer",cascade = CascadeType.REMOVE)
		private Order order;
//		@ManyToMany
//		@JoinTable(
//					name="ProCust_Table",
//					joinColumns = {@JoinColumn(name="Customer_Id")},
//					inverseJoinColumns = {@JoinColumn(name="Product_Id")}	
//				)
//		private List<ProductTable> product;
//		@OneToOne(cascade=CascadeType.ALL)
//		@JoinColumn(name="Order_id")
//		
		
		public CustomerTable() {
			super();
			// TODO Auto-generated constructor stub
		}
		

		public CustomerTable(long id, String name, long mobile_number, String date_of_order) {
	super();
	this.id = id;
	this.name = name;
	this.mobile_number = mobile_number;
	this.date_of_order = date_of_order;
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

		public long getMobile_number() {
			return mobile_number;
		}

		public void setMobile_number(long mobile_number) {
			this.mobile_number = mobile_number;
		}

		public String getDate_of_order() {
			return date_of_order;
		}



		public void setDate_of_order(String date_of_order) {
			this.date_of_order = date_of_order;
		}


		@Override
		public String toString() {
			return "CustomerTable [id=" + id + "]";
		}
		
		
}
