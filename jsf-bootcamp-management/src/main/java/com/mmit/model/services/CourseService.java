package com.mmit.model.services;

import java.util.List;

import com.mmit.model.entities.Course;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless
public class CourseService {

	@PersistenceContext
	private EntityManager em;
	
	
	public List<Course> findAll() {
		
		return em.createNamedQuery("getAllCourse", Course.class)
				.getResultList();
	}

	public Course findById(int id) {
		
		return em.find(Course.class, id);
	}

	public void save(Course course) {

		if(course.getId() == 0) 
			em.persist(course);
		else
			em.merge(course);

		
	}

	public List<Course> FindByLevelId(int l_id) {
		
		return em.createNamedQuery("getCourseByLevelId", Course.class)
				.setParameter("levelId", l_id)
				.getResultList();
	}

	public void deleById(int id) {
		var course = findById(id);
		
		em.remove(course);
	}
}
