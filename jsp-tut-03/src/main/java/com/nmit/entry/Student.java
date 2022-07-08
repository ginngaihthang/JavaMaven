package com.nmit.entry;

import java.time.LocalDate;

public class Student {
	private String name;
	private String phone;
	private String email;
	private LocalDate registerDate;
	private boolean oldStudent;
	private String batch;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	public boolean isOldStudent() {
		return oldStudent;
	}
	public void setOldStudent(boolean oldStudent) {
		this.oldStudent = oldStudent;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	
}
