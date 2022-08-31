package com.mmit.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BankAccount implements Serializable{

	private static final long serialVersionUID = 1L;
	private String bank_name;
	private String account_holder;
	private String account_number;
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getAccount_holder() {
		return account_holder;
	}
	public void setAccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	
}
