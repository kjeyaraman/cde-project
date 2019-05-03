package com.cts.projectmanager.dao;

import java.util.List;

import com.cts.projectmanager.mongo.model.User;

public interface UserDao {

	public void create(User user);

	public void update(User user);

	public void delete(String id);

	public User find(String id);

	public List<User> findAll();
	

}
