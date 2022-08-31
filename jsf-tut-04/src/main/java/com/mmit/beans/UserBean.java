package com.mmit.beans;

import java.io.Serializable;

import com.mmit.entities.User;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.Conversation;
import jakarta.enterprise.context.ConversationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ConversationScoped
public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private User user;
	@Inject
	private Conversation conversion;
	
	@PostConstruct
	public void init() {
		user = new User();
	}

	public String  saveLogin() {
		if(conversion.isTransient())
			conversion.begin();
		
		return "/reg-2";
	}
	
	public String saveDeatil() {
		
		return "/reg-3";
	}
	
	public String create() {
		if(!conversion.isTransient())
			conversion.end();
		
		return "/reg-1?faces-redirect=true";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
