package com.mmit;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Employee {

	@Size(min = 10, message = "Name must be at least 10 charactors")
	private String name;
	@NotBlank(message = "Email is required")
	@Email
	private String email;
	@Min(value = 10)
	@Max(60)
	private int age;
	@Min(value= 509000, message = "Salary must be at least 50000")
	private int salary;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
