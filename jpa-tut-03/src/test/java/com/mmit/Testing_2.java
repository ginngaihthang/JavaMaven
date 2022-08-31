package com.mmit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mmit.entity.User;

class Testing_2 {
	static EntityManagerFactory emf;
	static EntityManager em;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-tut-03");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void internal_callback() {
		var user = new User();
		user.setFirstName("Aung");
		user.setLastName("Aung");
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		//System.out.println("id : " + user.getId());
		
		em.detach(user);
		var user1 = em.find(User.class, "user_a8fb7889-cf56-48c4-bcb7-35b77d780a29");
		System.out.println("full name: " + user.getFullName());
	}

	//@Test
	void external_callback() {
		var user = new User();
		user.setFirstName("Kyaw");
		user.setLastName("Kyaw");
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		System.out.println("Id :  " + user.getId());
	}
	
	//@Test
	void external_cb_remove() {
//		var user = em.find(User.class, "user_f352d249-d4c0-46d6-98dc-3c91523482cd");
//		
//		em.getTransaction().begin();
//		em.remove(user);
//		em.getTransaction().commit();
//		
//		System.out.println("Id: " + user.getId());
	}
	
	//@Test
	void test3() {
		var user = new User();
		user.setFirstName("Tun");
		user.setLastName("Tun");
		
		user.setPhone(List.of("11111","22222"));
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	//@Test
	void test4() {
		var user = em.find(User.class, "user_0c6ae329-5e0e-4e57-9298-4ff98d6bcf1e");
		System.out.println("user: " + user);
		user.getPhone().add("333333");
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
}
