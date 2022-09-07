package com.mmit.model.services;

import java.util.List;

import com.mmit.model.entities.Batch;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class BatchService {

	@PersistenceContext
	private EntityManager em;
	
	
	public List<Batch> findAll() {
		TypedQuery<Batch> query = em.createNamedQuery("getAllBatch", Batch.class);
		List<Batch> list = query.getResultList();
		
		for(var l : list) {
			em.refresh(l);
		}
		return list;
	}

	

	public void save(Batch batch) {

		if(batch.getId() == 0) 
			em.persist(batch);
		else
			em.merge(batch);

		
	}

	public Batch FindById(int id) {

		return em.find(Batch.class, id);
	}

	public List<Batch> findByLevelId(int chosen_level_id) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("getBatchByLevelId" , Batch.class)
				.setParameter("levelId", chosen_level_id)
				.getResultList();
	}



	public void deleteById(int id) {
		var batch = em.find(Batch.class, id);
		
		em.remove(batch);
		
	}
}
