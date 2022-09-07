package com.mmit.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.mmit.model.entities.Level;
import com.mmit.model.services.LevelService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.RequestParameterMap;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class LevelBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private LevelService service;
	
	private Level level;
	
	private List<Level> levels;
	
	@RequestParameterMap
	@Inject
	private Map<String, String> params;
	
	@PostConstruct
	private void init() {
		String id = params.get("lvlId");
		if(id == null)
			level = new Level();
		else
			level = service.findById(Integer.parseInt(id));
			
		levels = service.findAll();
	}

	public String save() {
		service.save(level);
		return "/index?faces-redirect=true";
	}
	
	public String  delete(int id) {
		service.deleteById(id);
		
		return "/index?faces-redirect=true";
	}
	
	public List<Level> getLevels() {
		return levels;
	}


	public Level getLevel() {
		return level;
	}


	public void setLevel(Level level) {
		this.level = level;
	}
	
	
}
