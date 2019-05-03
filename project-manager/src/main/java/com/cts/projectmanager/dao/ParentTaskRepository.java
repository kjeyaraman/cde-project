package com.cts.projectmanager.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.cts.projectmanager.mongo.model.ParentTask;

@Repository
public class ParentTaskRepository implements ParentTaskDao {

	@Autowired
	MongoTemplate mongoTemplate;

	final String COLLECTION = "parenttask";

	@Override
	public void create(ParentTask parentTask) {
		mongoTemplate.insert(parentTask);

	}

	

	@Override
	public List<ParentTask> findAll() {
		return (List<ParentTask>) mongoTemplate.findAll(ParentTask.class);

	}

}
