package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "customers")
@NamedQuery(name = "findByName", query = "SELECT c FROM Customer c WHERE c.name LIKE :custName")

public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String email;
	private String name;
	private String city;
	private String phone;
	
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
   
}
