package com.mmit.bean;

import java.util.ArrayList;
import java.util.List;

import com.mmit.entities.Employee;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class EmployeeBean {

	private Employee employee;
	
//	@Inject
//	private EmployeeListBean listBean;
	
	@Inject
	@Named("empList")
	private List<Employee> list;
	
	public EmployeeBean() {
		employee = new Employee();
		System.out.println("This is constructor Bean");
	}
	
	public String save() {
		//listBean.getEmployee().add(employee);
		list.add(employee);
		return "/index?faces-redirect=true";
	}
	
	@Produces
	@Named("empList")
	@ApplicationScoped
	public List<Employee> getEmployees() {
		System.out.println("this is get produces");
		return new ArrayList<Employee>();
	}

	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String[] getPositions() {
		return new String[] {
				"Developer","Project Manager","Customer Support"
		};
	}
	
}
