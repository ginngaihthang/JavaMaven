package com.mmit.embedpk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: OrderItem
 *
 */
@Entity
@Table(name = "order_items")
public class OrderItem__embed implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPk_embed id;
	@Column(name = "sub_qty")
	private int subQty;
	@ManyToOne
	@JoinColumn(name = "order_id")
	@MapsId("order_id")
	private Order order;
	@ManyToOne
	@JoinColumn(name = "product_id")
	@MapsId("product_id")
	private Product product;
	public OrderItem__embed() {
		super();
	}
   
}
