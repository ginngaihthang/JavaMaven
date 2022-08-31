package com.mmit.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import static javax.persistence.AccessType.FIELD;
import static javax.persistence.AccessType.PROPERTY;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "users")
//@EntityListeners(UserAuditListener.class)
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private LocalDate registerDate;
	@Transient
	private String fullName;
	@ElementCollection
	@CollectionTable(joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "phone_number")
	private List<String> phone;
	
	@ElementCollection
	@CollectionTable(name = "user_bankinfos", joinColumns = @JoinColumn(name = "User_id"))
	private List<BankAccount> accounts;
	
	
	@PrePersist
	void beforeInsert() {
		System.out.println("Attempting to add new user...");
		registerDate = LocalDate.now();
		id = "user_" + UUID.randomUUID().toString();
		System.out.println(registerDate );
		System.out.println(id);
		
	}
	@PostPersist
	void loadUser() {
		System.out.println("After loading user...");
		fullName = firstName + " " + lastName;
	}
	public User() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public List<String> getPhone() {
		return phone;
	}
	public void setPhone(List<String> phone) {
		this.phone = phone;
	}
	public List<BankAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}
   
}
