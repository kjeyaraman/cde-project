package com.cts.projectmanager.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cts.projectmanager.mongo.model.Task;
import com.cts.projectmanager.vo.TaskVO;

@Repository
public class TaskRepository implements TaskDao {

	@Autowired
	MongoTemplate mongoTemplate;

	final String COLLECTION = "task";

	@Override
	public void create(Task task) {
		mongoTemplate.insert(task);

	}

	@Override
	public void update(Task task) {
		mongoTemplate.save(task);

	}

	@Override
	public List<TaskVO> findBy(String projId) {
		LookupOperation lookupOperation = LookupOperation.newLookup().from("parenttask").localField("parentTaskId")
				.foreignField("parentTaskId").as("parenttasks");
		Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("projId").is(projId)),
				lookupOperation);
		List<TaskVO> results = mongoTemplate.aggregate(aggregation, COLLECTION, TaskVO.class).getMappedResults();
		return results;
	}

	@Override
	public Task find(String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("taskId").is(id)), Task.class, COLLECTION);
	}

	@Override
	public long countByTask(String id) {
		return mongoTemplate.count(new Query(Criteria.where("projId").is(id)), Task.class, COLLECTION);
	}

	@Override
	public long countByTaskStatus(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("status").is("Completed"));
		query.addCriteria(Criteria.where("projId").is(id));
		return mongoTemplate.count(query, Task.class, COLLECTION);
	}

}
