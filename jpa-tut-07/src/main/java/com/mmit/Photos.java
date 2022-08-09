package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Photos
 *
 */
@Entity

public class Photos implements Serializable {

	@Id
	private int id;
	@Column(name = "photo_name")
	private String photoName;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@MapsId
	private Customers customer;
	
	
	
	private static final long serialVersionUID = 1L;

	public Photos() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
   
}
