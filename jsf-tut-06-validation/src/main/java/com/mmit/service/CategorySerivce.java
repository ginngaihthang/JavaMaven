package com.mmit.service;

import java.util.List;

import com.mmit.entity.Category;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless
public class CategorySerivce {

	@PersistenceContext
	private EntityManager em;

	public List<Category> findAll() {
		
		return em.createNamedQuery("findAllCategory",Category.class)
				.getResultList();
	}

	public Category findById(int id) {
		
		return em.find(Category.class, id);
	}

		
}
