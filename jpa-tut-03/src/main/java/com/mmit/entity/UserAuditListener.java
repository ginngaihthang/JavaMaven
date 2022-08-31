package com.mmit.entity;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class UserAuditListener {

	@PrePersist
	@PreRemove
	@PreUpdate
	private void beforeUpdate(User user) {
		if(user.getId() == null) {
			System.out.println("Adding new user");
			user.setRegisterDate(LocalDate.now());
			user.setId("user_" + UUID.randomUUID().toString());
		}
		else {
			System.out.println("Update/Delete user: " + user.getId());
		}
	}
	
	@PostPersist
	@PostRemove
	@PostUpdate
	private void afterUpdate(User user) {
		System.out.println("Add/Update/Delete user: " + user.getId());
	}
	
	@PostLoad
	private void load(User user) {
		System.out.println("Loading user: " + user.getId());
	}
}
