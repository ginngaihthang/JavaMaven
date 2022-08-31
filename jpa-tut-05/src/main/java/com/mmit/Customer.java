package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity

public class Customer implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String fullName;
	private String phone;
	@OneToOne(mappedBy = "customer")
	@PrimaryKeyJoinColumn 
	private CustomerDetail detail;
	
	public Customer() {
		super();
	}
   
}
