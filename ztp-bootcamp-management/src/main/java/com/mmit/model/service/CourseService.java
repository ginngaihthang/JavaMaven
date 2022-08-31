package com.mmit.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.mmit.model.entity.Course;

public class CourseService {

	private EntityManager em;
	
	public CourseService(EntityManager em) {
		this.em = em;
	}

	public List<Course> findAll() {
		
		return em.createNamedQuery("getAllCourse", Course.class)
				.getResultList();
	}

	public Course findById(int id) {
		
		return em.find(Course.class, id);
	}

	public void save(Course course) {
		em.getTransaction().begin();
		if(course.getId() == 0) 
			em.persist(course);
		else
			em.merge(course);
		em.getTransaction().commit();
		
	}

	public List<Course> FindByLevelId(int l_id) {
		
		return em.createNamedQuery("getCourseByLevelId", Course.class)
				.setParameter("levelId", l_id)
				.getResultList();
	}

	public void deleById(int id) {

		em.getTransaction().begin();
		var course = findById(id);
		em.remove(course);
		em.getTransaction().commit();
		
	}
}
