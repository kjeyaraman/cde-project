package com.cts.projectmanager.service;

import java.util.List;

import com.cts.projectmanager.mongo.model.User;

public interface UserService {
	public void addUser(User user);

	public void editUser(User user);

	public void removeUser(String id);

	public User findUser(String id);

	public List<User> getUserList();
	
}
