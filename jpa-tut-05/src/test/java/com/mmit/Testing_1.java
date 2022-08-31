package com.mmit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.platform.commons.annotation.Testable;

class Testing_1 {
	static EntityManagerFactory emf;
	static EntityManager em;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-tut-05");
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

	//@Test
	void test() {
		var order= new Order();
		order.setOrderDate(LocalDate.now());
		
		var item1= new OrderItem();
		item1.setProductName("Juice");
		item1.setSubQty(4);
		
		order.addItem(item1);
		
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
	}

	@Test
	@org.junit.jupiter.api.Order(1)
	void test_many_to_many() {
		var product = new Product_2();
		product.setName("coffee");
		product.setPrice(3500);
		
		var product1 = new Product_2();
		product1.setName("Juice");
		product1.setPrice(1500);
		
		var order = new Order_2();
		order.setOrderDate(LocalDate.now());
		
		order.addProduct(product);
		order.addProduct(product1);
		
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();

	}
	
	@Test
	@org.junit.jupiter.api.Order(2)
	void remove_from_order() {
		var product = em.find(Product_2.class, 1);
		
		var order = em.find(Order_2.class, 1);
		
		em.getTransaction().begin();
		order.removeProduct(product);
		em.getTransaction().commit();
	}
}
