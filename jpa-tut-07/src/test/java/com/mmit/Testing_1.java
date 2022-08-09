package com.mmit;


import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(OrderAnnotation.class)
class Testing_1 {

	static EntityManagerFactory emf;
	static EntityManager em;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-tut-07");
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
	@Order(1)
	void user_customer_merchant() {
		var user = new Users();
		user.setUserName("Aung Aung");
		user.setEmail("aung@gmail.com");
		user.setPassword("1234");
		user.setIsActive(true);
		
		var merchant = new Merchants();
		merchant.setPrimaryPhone("09343443");
		merchant.setSecondaryPhone("08294823");
		merchant.setShopName("Star");
		merchant.setAddress("Pyin Oo Lwin");
		
		
		var customer = new Customers();
		customer.setFirstName("Kyaw");
		customer.setLastName("Kyaw");
		customer.setPhone("02342304");
		customer.setGender(null);
		
		user.setMerchant(merchant);
		merchant.setUser(user);
		
		user.setCustomer(customer);
		customer.setUser(user);
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	
	@Test
	@Order(2)
	void customer_photo() {
		var photo = new Photos();
		photo.setPhotoName("img");
		
		var customer = em.find(Customers.class, 1);
		
		customer.addPhoto(photo);
		
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		
	}
	
	@Test
	@Order(3)
	void customer_order() {
		var order = new Orders();
		order.setShippingAddress("kalay");
		order.setShippingPhone("0482394");
		order.setTotalAmount(1000000d);
		order.setOrderDate(LocalDate.now());
		
		var customer = em.find(Customers.class, 1);
		
		customer.addOrder(order);
		
		em.getTransaction().begin();
//		em.persist(customer);
		em.persist(order);
		em.getTransaction().commit();
	}
	
	@Test
	@Order(4)
	void orderItem_order_delivery() {
		var item = new OrderItem();
		item.setSubQty(4);
		
		var delivery = new Deliveries();
		delivery.setDeliveryMan("deliver");
		delivery.setDeliveryDate(LocalDate.now());
		delivery.setIsDelieved(true);
		
		var order = em.find(Orders.class, 1);
		
		order.setDelivery(delivery);
		delivery.setOrder(order);
		order.addOrderItem(item);
		
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
	}
	
	@Test
	@Order(5)
	void orderItem_product() {
		var product = new Products();
		product.setName("coffee");
		product.setPrice(2500.0f);
		
		var item = em.find(OrderItem.class, 1);
		
		product.addItem(item);
		
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		
	}
	
	@Test
	@Order(6)
	void product_category() {
		var category = new Categories();
		category.setName("juice");
		category.setDescription("dsdk");
		
		var product  = em.find(Products.class, 1);
		      
		category.addProduct(product);
		
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
	}

}
