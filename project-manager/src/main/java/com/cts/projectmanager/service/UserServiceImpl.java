package com.cts.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanager.dao.UserRepository;
import com.cts.projectmanager.mongo.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void addUser(User user) {
		userRepository.create(user);

	}

	@Override
	public void editUser(User user) {
		User userObj=userRepository.find(user.getEmpId());
		    userObj.setFname(user.getEmpId());
			userObj.setFname(user.getFname());
			userObj.setLname(user.getLname());
			userRepository.update(userObj);

	}

	@Override
	public void removeUser(String id) {
		userRepository.delete(id);

	}

	@Override
	public User findUser(String id) {
		return userRepository.find(id);
	}

	@Override
	public List<User> getUserList() {
		return userRepository.findAll();
	}



}
