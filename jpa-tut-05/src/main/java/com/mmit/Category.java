package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column(nullable = false, unique = true)
	private String name;
	public Category() {
		super();
	}
   
}
