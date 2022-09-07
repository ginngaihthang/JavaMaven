package com.mmit.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name ="bootcamper")
@NamedQuery(name ="getAllBootcamper", query="SELECT b FROM Bootcamper b ")
@NamedQuery(name = "getBootCampByBathId", query="SELECT b FROM Bootcamper b WHERE b.batch.id = :batchId")
public class Bootcamper implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name is required")
	private String name;
	@Column(unique= true)
	@NotBlank(message = "Email is requried")
	@Email
	private String email;
	@Column(unique= true)
	@Min(value = 11, message ="Phone number must be at least 11")
	private String phone;
	private LocalDate registerDate;
	@ManyToOne
	@JoinColumn(name = "batch_id")
	private Batch batch;
	
	private static final long serialVersionUID = 1L;

	public Bootcamper() {
		super();
	}
	
	@PrePersist
	public void perInt() {
		registerDate = LocalDate.now();
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

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
   
}
