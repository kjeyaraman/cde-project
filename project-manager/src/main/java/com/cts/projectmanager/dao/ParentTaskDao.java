package com.cts.projectmanager.dao;

import java.util.List;

import com.cts.projectmanager.mongo.model.ParentTask;

public interface ParentTaskDao {
	public void create(ParentTask parentTask);


	public List<ParentTask> findAll();
}
