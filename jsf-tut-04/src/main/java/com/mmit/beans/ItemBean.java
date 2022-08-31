package com.mmit.beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mmit.entities.Item;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ItemBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Item item;
	private List<Item> list;
	
	public ItemBean() {
		System.out.println("This is Constructor");
	}
	
	@PostConstruct
	public void init() {
		item = new Item();
		list = new ArrayList<Item>();
		System.out.println("This is post Constructor");
	}

	public String save() {
		if(item.getId() == 0) {
			item.setId(list.isEmpty() ? 1 : list.get(list.size() -1).getId() + 1);
			list.add(item);
		}
		else {
			for(var i = 0; i < list.size(); i++) {
				if(list.get(i).getId() == item.getId()) {
					list.set(i, item);
					break;
				}
			}
		}
		item = new Item();
		System.out.println("size: " +list.size());
		
		return null;
	}
	
	public void delete(int id) {
		list.removeIf(item -> item.getId() == id);
	}
	
	public void detail(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	} 

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}
	
}
