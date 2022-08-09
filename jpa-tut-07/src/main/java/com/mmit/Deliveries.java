package com.mmit;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity

public class Deliveries implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "delivery_man", nullable = false)
	private String deliveryMan;
	@Column(name = "delivery_date")
	private LocalDate deliveryDate;
	@Column(name = "is_delived")
	private Boolean isDelieved;
	
	@OneToOne
	@JoinColumn(name = "order_id")
	private Orders order;
	
	private static final long serialVersionUID = 1L;

	public Deliveries() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeliveryMan() {
		return deliveryMan;
	}

	public void setDeliveryMan(String deliveryMan) {
		this.deliveryMan = deliveryMan;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Boolean getIsDelieved() {
		return isDelieved;
	}

	public void setIsDelieved(Boolean isDelieved) {
		this.isDelieved = isDelieved;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
	   
}
