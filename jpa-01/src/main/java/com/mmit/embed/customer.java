package com.mmit.embed;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column(name= "customer_code")
	private String customerCode;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "firstName", column = @Column(name = "frist_name")),
		@AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
	})
	private BasicInfo basicInfo;
	public customer() {
		super();
	}

}
