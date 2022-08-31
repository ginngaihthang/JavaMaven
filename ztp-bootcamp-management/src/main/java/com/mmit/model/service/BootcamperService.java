package com.mmit.model.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mmit.model.entity.Bootcamper;


public class BootcamperService {

	private EntityManager em;
	
	public BootcamperService(EntityManager em) {
		this.em = em;
	}

	public List<Bootcamper> findAll() {
		
		TypedQuery<Bootcamper> query = em.createNamedQuery("getAllBootcamper", Bootcamper.class);
		
		List<Bootcamper> list = query.getResultList();
		
		return list;
	}

	public Bootcamper findById(int id) {
		return em.find(Bootcamper.class, id);
	}

	public void save(Bootcamper boot) {
		em.getTransaction().begin();
		if(boot.getId() == 0)
			em.persist(boot);
		else
			em.merge(boot);
		em.getTransaction().commit();
		
	}

	public List<Bootcamper> findByBatchId(int batch_id) {
		
		return em.createNamedQuery("getBootCampByBathId", Bootcamper.class)
				.setParameter("batchId", batch_id)
				.getResultList();
	}
}
