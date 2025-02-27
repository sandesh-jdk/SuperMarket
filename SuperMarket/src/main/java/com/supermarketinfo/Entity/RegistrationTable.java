package com.supermarketinfo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Registration_Table")
public class RegistrationTable 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="User_Name")
	private String name;
	@Column(name="Email")
	private String email;
	@Column(name="Mobile_Number")
	private long number;
	@Column(name="Address")
	private String address;
	@Column(name="Password")
	private String password;
	@Column(name="User_Id" , unique = true)
	private long u_id;
	public RegistrationTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegistrationTable(String name, String email, long number, String address, String password, long u_id) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
		this.address = address;
		this.password = password;
		this.u_id = u_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getU_id() {
		return u_id;
	}
	public void setU_id(long u_id) {
		this.u_id = u_id;
	}
	
	
	
}
