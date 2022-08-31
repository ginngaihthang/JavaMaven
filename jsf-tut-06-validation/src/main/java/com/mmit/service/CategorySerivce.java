package com.mmit.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CategorySerivce {

	@PersistenceContext
	private EntityManager em;
}
