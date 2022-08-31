package com.nmit.entry;

import java.time.LocalDate;

public class Batch {
	private String name;
	private LocalDate start_date;
	
	public Batch() {
		
	}
	public Batch(String name, LocalDate start_date) {
		super();
		this.name = name;
		this.start_date = start_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	
}
