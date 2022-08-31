package com.mmit.embed;

import java.io.Serializable;
import javax.persistence.*;

@Entity

public class Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String name;
	@Transient
	private int age;
	private transient float bonus;
	static int company_name;// auto transient
	public Employee() {
		super();
	}
   
}
