package com.mmit;                                         
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mmit.entity.Batch;
import com.mmit.entity.Student;

class Testing_1 {
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
	void test() {
		var student = new Student();
		student.setEmail("kyaw@gmail.com");
		student.setName("Kyaw");
		System.out.print("In before persist: "  + student.getId());
		em.getTransaction().begin();
		em.persist(student);
		//em.flush();
		em.getTransaction().commit();
		System.out.print("In after persist: "  + student.getId());
	}
	
	//@Test
	void test2() {
		var student = new Student();
		student.setEmail("tun@gmail.com");
		student.setName("Tun");
		
		
		var batch = new Batch();
		batch.setName("Batch 1");
		
		student.setBatch(batch);
		
		em.getTransaction().begin();
		em.persist(student);
		em.persist(batch);
		
		em.getTransaction().commit();
	}
	//@Test
	void test3() {
		
		var std = new Student();
		std.setEmail("cherry@gmail.com");
		std.setName("Chery");
		
		var batch = em.find(Batch.class, 1); // managed state
		//var batch = em.getReference(Batch.class, 1); // just contain id
		
		em.getTransaction().begin();
		em.persist(std);
		em.getTransaction().commit();
		
		System.out.println("BAtch name : " + batch.getName());
		System.out.println("Batch id: " + batch.getId());
		 
		//var batch_1 = em.find(Batch.class, 1); // not hit db, just retrieve pc.
	}
	//@Test
	void test4() {
		var student = em.find(Student.class, 1);
		//em.detach(student); //managed state to detached state(out ofr context)
		em.clear(); // detached state 
		em.getTransaction().begin();
		var student_1 = em.merge(student); // from detached to managed state
		em.getTransaction().commit();
		
		System.out.println("Contain in context: " + em.contains(student_1));
	}

	//@Test
	void test5() {
		var std = em.find(Student.class, 1); // managed state
		
		em.getTransaction().begin();
		std.setName("Jeon"); // update via setXX
		em.getTransaction().commit();
		
	}
	
	//@Test
	void test6() {
		var student = em.find(Student.class, 1);// managed state
		
		em.detach(student); // detache 
		
		em.getTransaction().begin();
		student.setEmail("jeon@gmail.com");
		em.merge(student);
		em.getTransaction().commit();
			}
	
	//@Test
	void test7() {
		var student = em.find(Student.class, 1);
		
		em.getTransaction().begin();
		em.remove(student); // managed to removed state
		em.persist(student);
		//em.clear(); // removed state to detached state
		em.getTransaction().commit();
		
		//System.out.println("conatin: " + em.contains(student));
	}
}
