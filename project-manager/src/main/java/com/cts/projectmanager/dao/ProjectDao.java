package com.cts.projectmanager.dao;

import java.util.List;

import com.cts.projectmanager.mongo.model.Project;

public interface ProjectDao {
	public void create(Project project);

	public void update(Project project);


	public Project find(String id);

	public List<Project> findAll();
}
