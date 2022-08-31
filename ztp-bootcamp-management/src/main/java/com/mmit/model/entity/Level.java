package com.mmit.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.FetchType.EAGER;

/**
 * Entity implementation class for Entity: Level
 *
 */
@Entity
@Table(name = "levels")
@NamedQuery(name = "getAllLevel", query = "SELECT l FROM Level l")
public class Level implements Serializable {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	private String name;
	private int duration;
	private int fees;
	@OneToMany(mappedBy="level")
	private List<Batch> batch = new ArrayList<Batch>();
	@OneToMany(mappedBy= "level")
	private List<Course> course = new ArrayList<Course>();
	private static final long serialVersionUID = 1L;

	public Level() {
		super();
	}

	public int getTotalBatch() {
		return batch.size();
	}
	public int getTotalCourse() {
		return course.size();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}
   
}
