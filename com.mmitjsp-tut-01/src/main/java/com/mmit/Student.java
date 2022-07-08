package com.mmit;

import java.time.LocalDate;

public class Student {
	private String name;
	private String email;
	private int age;
	private LocalDate birthday;
	private String region;
	private String gender;
	private String address;
	private boolean old_student;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isOld_student() {
		return old_student;
	}
	public void setOld_student(boolean old_student) {
		this.old_student = old_student;
	}
	
}
