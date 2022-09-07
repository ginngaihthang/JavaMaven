package com.mmit.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mmit.model.entities.Batch;
import com.mmit.model.services.BatchService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.RequestParameterMap;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class BatchBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private BatchService service;
	
	private Batch batch;
	
	private List<Batch> batches;
	
	@RequestParameterMap
	@Inject
	private Map<String , String> params;
	
	@PostConstruct
	public void init() {
		String id = params.get("batchId");
		if(id == null)
			batch = new Batch();
		else
			batch = service.FindById(Integer.parseInt(id));
			
		batches = service.findAll();
	}
	
	public String save() {
		service.save(batch);
		return "/batch-list?faces-redirect=true";
	}
	
	public String delete(int id) {
		service.deleteById(id);
		return "/batch-list?faces-redirect=true";
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public List<Batch> getBatches() {
		return batches;
	}
	
	
}
