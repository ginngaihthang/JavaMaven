package com.mmit.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.mmit.model.entities.Course;
import com.mmit.model.services.CourseService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.RequestParameterMap;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class CourseBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CourseService service;
	
	private Course course;
	
	private List<Course> courses;
	
	@RequestParameterMap
	@Inject
	private Map<String, String> params;
	
	@PostConstruct
	public void init() {
		String id = params.get("courseId");
		if(id == null) 
			course = new Course();
		else
			course = service.findById(Integer.parseInt(id));
		
		courses = service.findAll();
	}
	
	public String save() {
		service.save(course);
		return "/course-list?faces-redirect=true";
	}
	
	public String delete(int id) {
		service.deleById(id);
		return "/course-list?faces-redirect=true";
	}

	public List<Course> getCourses() {
		return courses;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
