package com.mmit.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.AccessType.FIELD;
import static javax.persistence.AccessType.PROPERTY;

@Entity
@Table(name ="bootcamper")
@NamedQuery(name ="getAllBootcamper", query="SELECT b FROM Bootcamper b ")
@NamedQuery(name = "getBootCampByBathId", query="SELECT b FROM Bootcamper b WHERE b.batch.id = :batchId")
public class Bootcamper implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique= true)
	private String email;
	@Column(unique= true)
	private String phone;
	@ManyToOne
	@JoinColumn(name = "batch_id")
	private Batch batch;
	
	private static final long serialVersionUID = 1L;

	public Bootcamper() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}
   
}
