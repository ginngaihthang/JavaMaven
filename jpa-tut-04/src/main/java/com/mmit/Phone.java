package com.mmit;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;
import static javax.persistence.AccessType.FIELD;
import static javax.persistence.AccessType.PROPERTY;
import static javax.persistence.DiscriminatorType.CHAR;
import static javax.persistence.DiscriminatorType.INTEGER;
import static javax.persistence.DiscriminatorType.STRING;

/**
 * Entity implementation class for Entity: Phone
 *
 */
@Entity
public class Phone implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String number;
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	public Phone() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
   
}
