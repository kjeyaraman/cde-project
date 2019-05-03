package com.cts.projectmanager.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cts.projectmanager.mongo.model.Project;

@Repository
public class ProjectRepository implements ProjectDao {
	@Autowired
	MongoTemplate mongoTemplate;

	final String COLLECTION = "project";

	@Override
	public void create(Project project) {
		mongoTemplate.insert(project);

	}

	@Override
	public void update(Project project) {
		mongoTemplate.save(project);

	}



	@Override
	public Project find(String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("projId").is(id)), Project.class, COLLECTION);
	}

	@Override
	public List<Project> findAll() {
		
		return mongoTemplate.findAll(Project.class);


	}
}
