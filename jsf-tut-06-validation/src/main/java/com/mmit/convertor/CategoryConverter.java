package com.mmit.convertor;

import com.mmit.entity.Category;
import com.mmit.service.CategorySerivce;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class CategoryConverter implements Converter<Category>{

	@Inject
	private CategorySerivce service;
	
	@Override
	public Category getAsObject(FacesContext context, UIComponent component, String id) {
		if(id != null) {
			var cat = service.findById(Integer.parseInt(id));
			return cat;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Category value) {
		//categoryId
		return String.valueOf(value.getId());
	}

}
