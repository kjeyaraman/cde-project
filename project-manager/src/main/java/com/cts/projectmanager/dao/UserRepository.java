package com.cts.projectmanager.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cts.projectmanager.mongo.model.User;

@Repository
public class UserRepository  implements UserDao  {

	@Autowired
	MongoTemplate mongoTemplate;

	final String COLLECTION = "user";

	@Override
	public void create(User user) {
		mongoTemplate.insert(user);

	}

	@Override
	public void update(User user) {
		mongoTemplate.save(user);

	}

	@Override
	public void delete(String id) {
		mongoTemplate.remove(new Query(Criteria.where("empId").is(id)), User.class);
	}

	@Override
	public User find(String id) {
	     return mongoTemplate.findOne(new Query(Criteria.where("empId").is(id)), User.class, COLLECTION);
	}

	@Override
	public List<User> findAll() {
		return (List<User>) mongoTemplate.findAll(User.class);

	}



	
}
