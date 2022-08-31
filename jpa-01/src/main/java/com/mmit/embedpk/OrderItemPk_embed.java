package com.mmit.embedpk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Embeddable
public class OrderItemPk_embed implements Serializable {

	private int product_id;
	private int order_id;
	@Override
	public int hashCode() {
		return Objects.hash(order_id, product_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPk_embed other = (OrderItemPk_embed) obj;
		return order_id == other.order_id && product_id == other.product_id;
	}
	
   
}
