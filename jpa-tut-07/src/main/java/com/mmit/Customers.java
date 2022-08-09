package com.mmit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.AccessType.FIELD;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REMOVE;

/**
 * Entity implementation class for Entity: Customers
 *
 */
@Entity
public class Customers implements Serializable {

	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String Phone;
	@Column(name = "gender_name")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@OneToOne
	@JoinColumn(name = "user_id")
	@MapsId
	private Users user;
	@OneToMany(mappedBy = "customer", cascade = { PERSIST, MERGE, REMOVE })
	private List<Photos> photo = new ArrayList<Photos>();
	
	@OneToMany(mappedBy = "customer")
	private List<Orders> order = new ArrayList<Orders>();

	
	
	private static final long serialVersionUID = 1L;

	public Customers() {
		super();
	}
	
	enum Gender {
		male,
		female
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Photos> getPhoto() {
		return photo;
	}

	public void setPhoto(List<Photos> photo) {
		this.photo = photo;
	}

	public List<Orders> getOrder() {
		return order;
	}

	public void setOrder(List<Orders> order) {
		this.order = order;
	}

	public void addPhoto(Photos photo2) {
		photo2.setCustomer(this);
		this.photo.add(photo2);
		
	}

	public void addOrder(Orders order2) {
		order2.setCustomer(this);
		this.order.add(order2);
		
	}

	
   
}
