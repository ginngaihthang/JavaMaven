package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.AccessType.FIELD;
import static javax.persistence.AccessType.PROPERTY;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "user_name",nullable = false)
	private String userName;
	@Column(unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(name = "is_active")
	private Boolean isActive;
	@OneToOne(mappedBy = "user", cascade = ALL)
	@PrimaryKeyJoinColumn
	private Merchants merchant;
	@OneToOne(mappedBy = "user",cascade =ALL )
	@PrimaryKeyJoinColumn
	private Customers customer;
	
	private static final long serialVersionUID = 1L;

	public Users() {
		super();
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Merchants getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchants merchant) {
		this.merchant = merchant;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	

	
	  
	
}
