package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CustomerDetail
 *
 */
@Entity

public class CustomerDetail implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	@OneToOne
	@JoinColumn(name = "cust_id")
	@MapsId
	private Customer customer;
	public CustomerDetail() {
		super();
	}
   
}
