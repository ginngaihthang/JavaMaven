package com.mmit.embedpk;

import java.io.Serializable;
import java.util.Objects;

public class OrderItemPk implements Serializable{


	private static final long serialVersionUID = 1L;
	private int order;
	private int product;
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPk other = (OrderItemPk) obj;
		return order == other.order && product == other.product;
	}
	
}
