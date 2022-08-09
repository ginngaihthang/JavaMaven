package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

import org.w3c.dom.Text;

@Entity
@Table(name = "merchants")
public class Merchants implements Serializable {

	@Id
	private int id;
	@Column(name = "primary_phone")
	private String primaryPhone;
	@Column(name = "secondary_phone")
	private String secondaryPhone;
	@Column(name = "shop_name")
	private String shopName;
	@Column(columnDefinition="TEXT")
	private String address;
	@OneToOne
	@JoinColumn(name = "user_id")
	@MapsId
	private Users user;
	
	
	private static final long serialVersionUID = 1L;

	public Merchants() {
		super();
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
   
}
