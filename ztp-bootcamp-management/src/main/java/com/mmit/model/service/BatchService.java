package com.mmit.model.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mmit.model.entity.Batch;

public class BatchService {

	private EntityManager em;
	
	public BatchService(EntityManager em) {
		this.em = em;
	}

	public List<Batch> findAll() {
		TypedQuery<Batch> query = em.createNamedQuery("getAllBatch", Batch.class);
		List<Batch> list = query.getResultList();
		
		for(var l : list) {
			em.refresh(l);
		}
		return list;
	}

	

	public void save(Batch batch) {
		em.getTransaction().begin();
		if(batch.getId() == 0) 
			em.persist(batch);
		else
			em.merge(batch);
		em.getTransaction().commit();
		
	}

	public Batch FindById(int id) {

		return em.find(Batch.class, id);
	}

	public List<Batch> findByLevelId(int lvl_id) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("getBatchByLevelId" , Batch.class)
				.setParameter("levelId", lvl_id)
				.getResultList();
	}
}
