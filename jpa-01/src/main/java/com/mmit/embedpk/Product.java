package com.mmit.embedpk;

import java.io.Serializable;
import javax.persistence.*;

@Entity

public class Product implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String name;
	private float price;
	public Product() {
		super();
	}
   
}
