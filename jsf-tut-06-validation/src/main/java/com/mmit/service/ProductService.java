package com.mmit.service;


import java.util.List;

import com.mmit.entity.Product;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class ProductService {

	@PersistenceContext
	private EntityManager em;
	public List<Product> findAll() {
		TypedQuery<Product> query = em.createNamedQuery("getAllProduct", Product.class);
		
		List<Product> list = query.getResultList();
		
		return list;
	}

		public void save(Product product) {
			if(product.getId() == 0)
				em.persist(product);
			else
				em.merge(product);
			
		}

		public void deleteById(int productId) {
			var product = em.find(Product.class, productId);
			
			em.remove(product);
		}

		public Product findById(int id) {
			
			return em.find(Product.class, id);
		}

}
