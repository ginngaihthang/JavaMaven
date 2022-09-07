package com.mmit.bean;

import java.util.List;

import com.mmit.entity.Category;
import com.mmit.service.CategorySerivce;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class CategoryBean {

	private List<Category> categories;
	
	@Inject
	private CategorySerivce service;
	
	@PostConstruct
	private void init()  {
		System.out.println("cateoty post constructor");
		categories = service.findAll();
	}

	public List<Category> getCategories() {
		return categories;
	}
	
	
}
