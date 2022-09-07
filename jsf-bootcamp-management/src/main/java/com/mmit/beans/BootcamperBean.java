package com.mmit.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mmit.model.entities.Batch;
import com.mmit.model.entities.Bootcamper;
import com.mmit.model.services.BatchService;
import com.mmit.model.services.BootcamperService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.RequestParameterMap;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class BootcamperBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private BootcamperService service;
	
	@Inject
	private BatchService batchService;
	
	private Bootcamper bootcamper;
	
	private List<Bootcamper> bootcampers;
	
	private int chosen_level_id;
	
	private List<Batch> batchList;
	
	@RequestParameterMap
	@Inject
	private Map<String, String> params;
	
	@PostConstruct
	public void init() {
		String id = params.get("bootId");
		if(id == null) 
			bootcamper = new Bootcamper();
		else 
			bootcamper = service.findById(Integer.parseInt(id));
		batchList = new ArrayList<Batch>();
	}
	
	public void retrieveBatchList() {
		System.err.println("choosen level id : " + chosen_level_id);
		batchList = batchService.findByLevelId(chosen_level_id);
	}
	
	public void delete(int id) {
		service.deleteById(id);
	}
	
	public String save() {
		service.save(bootcamper);
		return "bootcamper-list?faces-redirect=true";
	}

	public Bootcamper getBootcamper() {
		return bootcamper;
	}

	public void setBootcamper(Bootcamper bootcamper) {
		this.bootcamper = bootcamper;
	}

	public List<Bootcamper> getBootcampers() {
		bootcampers = service.findAll();
		return bootcampers;
	}

	public int getChosen_level_id() {
		return chosen_level_id;
	}

	public void setChosen_level_id(int chosen_level_id) {
		this.chosen_level_id = chosen_level_id;
	}

	public List<Batch> getBatchList() {
		return batchList;
	}
	
	
	
}
