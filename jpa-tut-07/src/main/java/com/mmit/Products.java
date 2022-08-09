package com.mmit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.PERSIST;

/**
 * Entity implementation class for Entity: Products
 *
 */
@Entity

public class Products implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Float price;
	
	@OneToMany(mappedBy = "product", cascade = PERSIST)
	private List<OrderItem> item = new ArrayList<OrderItem>();
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Categories category;
	
	
	private static final long serialVersionUID = 1L;

	public Products() {
		super();
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<OrderItem> getItem() {
		return item;
	}

	public void setItem(List<OrderItem> item) {
		this.item = item;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public void addItem(OrderItem item2) {
		item2.setProduct(this);
		this.item.add(item2);
		
	}
   
}
