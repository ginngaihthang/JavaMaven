package com.mmit;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.PERSIST;

/**
 * Entity implementation class for Entity: Orders
 *
 */
@Entity

public class Orders implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name  = "shipping_address")
	private String shippingAddress;
	@Column(name = "shipping_phone")
	private String shippingPhone;
	@Column(name = "total_amount")
	private Double totalAmount;
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	@OneToOne(mappedBy = "order", cascade = PERSIST)
	private Deliveries Delivery;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customer;
	
	@OneToMany(mappedBy = "order", cascade = PERSIST)
	private List<OrderItem> order = new ArrayList<OrderItem>();
	
	private static final long serialVersionUID = 1L;

	public Orders() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingPhone() {
		return shippingPhone;
	}

	public void setShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public List<OrderItem> getOrder() {
		return order;
	}

	public void setOrder(List<OrderItem> order) {
		this.order = order;
	}

	public void addOrderItem(OrderItem item) {
		item.setOrder(this);
		this.order.add(item);
		
	}

	public Deliveries getDelivery() {
		return Delivery;
	}

	public void setDelivery(Deliveries delivery) {
		Delivery = delivery;
	}
   
}
