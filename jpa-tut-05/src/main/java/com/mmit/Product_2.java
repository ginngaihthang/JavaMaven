package com.mmit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
//@Entity

public class Product_2 implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToMany
	@JoinTable(name = "OrderItems", 
	joinColumns = @JoinColumn(name = "product_id"), 
	inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<Order_2> orders = new ArrayList<Order_2>();
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Order_2> getOrders() {
		return orders;
	}

	public void setOrders(List<Order_2> orders) {
		this.orders = orders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private String name;
	private int price;
	private static final long serialVersionUID = 1L;

	public Product_2() {
		super();
	}
   
}