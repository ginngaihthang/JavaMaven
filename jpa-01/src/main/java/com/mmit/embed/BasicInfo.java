package com.mmit.embed;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BasicInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String  phone;
	

}
