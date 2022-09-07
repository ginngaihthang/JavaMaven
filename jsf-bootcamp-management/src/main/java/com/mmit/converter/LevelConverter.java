package com.mmit.converter;

import com.mmit.model.entities.Level;
import com.mmit.model.services.LevelService;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class LevelConverter implements Converter<Level>{

	@Inject
	private LevelService service;
	
	@Override
	public Level getAsObject(FacesContext context, UIComponent component, String id) {
		if(id != null) {
			var lvl = service.findById(Integer.parseInt(id));
			return lvl;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Level value) {
	
		return String.valueOf(value.getId());
	}
	
}
