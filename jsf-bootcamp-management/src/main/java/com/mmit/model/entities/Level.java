package com.mmit.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;



@Entity
@Table(name = "levels")
@NamedQuery(name = "getAllLevel", query = "SELECT l FROM Level l")
public class Level implements Serializable {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name is required")
	private String name;
	@Min(value = 1, message = "Duration is required")
	private int duration;
	@Min(value = 1, message = "Fees is required")
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Level other = (Level) obj;
		return id == other.id;
	}
   
	
}
