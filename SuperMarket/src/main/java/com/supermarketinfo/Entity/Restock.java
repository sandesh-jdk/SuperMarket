package com.supermarketinfo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
@Entity
@Table(name="Restock_Table")
public class Restock 
{	
	@Id
	private long Id;
	@Column(name="Brand")
	private String r_brand;
	@Column(name="Name")
	private String r_name;
	@Column(name="Quantity")
	private int r_quantity;
	
	public Restock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restock(long id, String r_brand, String r_name, int r_quantity) {
		super();
		Id = id;
		this.r_brand = r_brand;
		this.r_name = r_name;
		this.r_quantity = r_quantity;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getR_brand() {
		return r_brand;
	}
	public void setR_brand(String r_brand) {
		this.r_brand = r_brand;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public int getR_quantity() {
		return r_quantity;
	}
	public void setR_quantity(int r_quantity) {
		this.r_quantity = r_quantity;
	}
	@Override
	public String toString() {
		return String.valueOf(Id);
	}
	
	
	
}
