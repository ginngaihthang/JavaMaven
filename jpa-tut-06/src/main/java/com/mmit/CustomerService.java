package com.mmit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CustomerService {
	
	private EntityManager em;
	
	public CustomerService(EntityManager em) {
		this.em = em;
	}
	
	public void save(Customer cust) {
		em.getTransaction().begin();
		em.persist(cust);
		em.getTransaction().commit();
	}
	
	public List<Customer> querycerate() {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.name LIKE :custName",Customer.class);
		
		query.setParameter("custName", "%aung%");
		List<Customer> list = query.getResultList();
		
		return list;
	}
	
	public List<Customer> findName(String name) {
		TypedQuery<Customer> query = em.createNamedQuery("findByName", Customer.class);
		
		query.setParameter("custName", "%" + name + "%");
		
		var list = query.getResultList();
		return list;
	}

	public Customer findByemail(String email) {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE email = :email", Customer.class);
		query.setParameter("email", email);

		return query.getSingleResult();
		
		
	}
}
