package com.mmit.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ProductService {

	@PersistenceContext
	private EntityManager em;
}
