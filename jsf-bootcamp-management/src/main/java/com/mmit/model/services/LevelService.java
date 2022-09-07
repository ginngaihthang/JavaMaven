package com.mmit.model.services;

import java.util.List;
import com.mmit.model.entities.Level;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class LevelService {

	@PersistenceContext
	private EntityManager em;
	

	public void save(Level lvl) {
		
		if(lvl.getId() == 0)
			em.persist(lvl);
		else
			em.merge(lvl);

		
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

	public void deleteById(int id) {
		var level = em.find(Level.class, id);
		
		em.remove(level);
		
	}
}
