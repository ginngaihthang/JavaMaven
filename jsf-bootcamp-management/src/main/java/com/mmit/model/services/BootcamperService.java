package com.mmit.model.services;

import java.util.List;

import com.mmit.model.entities.Batch;
import com.mmit.model.entities.Bootcamper;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class BootcamperService {

	
	@PersistenceContext
	private EntityManager em;
	
	
	public List<Bootcamper> findAll() {
		
		TypedQuery<Bootcamper> query = em.createNamedQuery("getAllBootcamper", Bootcamper.class);
		
		List<Bootcamper> list = query.getResultList();
		
		return list;
	}

	public Bootcamper findById(int id) {
		return em.find(Bootcamper.class, id);
	}

	public void save(Bootcamper boot) {
		if(boot.getId() == 0)
			em.persist(boot);
		else
			em.merge(boot);
		
	}

	public List<Bootcamper> findByBatchId(int batch_id) {
		
		return em.createNamedQuery("getBootCampByBathId", Bootcamper.class)
				.setParameter("batchId", batch_id)
				.getResultList();
	}

	public void deleteById(int id) {
		var boot = findById(id);
		
		em.remove(boot);
		
	}

	
}
