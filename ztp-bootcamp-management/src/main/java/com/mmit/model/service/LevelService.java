package com.mmit.model.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mmit.model.entity.Level;

public class LevelService {

	private EntityManager em;
	
	public LevelService(EntityManager em) {
		this.em = em;
	}

	public void save(Level lvl) {
		em.getTransaction().begin();
		if(lvl.getId() == 0)
			em.persist(lvl);
		else
			em.merge(lvl);
		em.getTransaction().commit();
		
	}

	public List<Level> findAll() {
		TypedQuery<Level> query = em.createNamedQuery("getAllLevel", Level.class);
		
		List<Level> list = query.getResultList();
		for(var l : list) {
			em.refresh(l);
		}
		return list;
	}

	public Level findById(int id) {
		
		return em.find(Level.class, id);
	}
}
