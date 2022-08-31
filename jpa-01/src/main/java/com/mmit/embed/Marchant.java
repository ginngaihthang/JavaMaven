package com.mmit.embed;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Marchant
 *
 */
//@Entity

public class Marchant implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String marchantCode;
	private String shopName;
	@Embedded
	private BasicInfo basicInfo;
	public Marchant() {
		super();
	}
   
}
