package com.mmit.embedpk;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@IdClass(OrderItemPk.class)
public class OrderItem implements Serializable {

	
	private static final long serialVersionUID = 1L;
//	@Id
//	private int product_id;
//	@Id
//	private int order_id;
	@Column(name = "sub_qty")
	private int subQty;
	@Id
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	public OrderItem() {
		super();
	}
   
}
