package com.cts.projectmanager.dao;

import java.util.List;

import com.cts.projectmanager.mongo.model.Task;
import com.cts.projectmanager.vo.TaskVO;

public interface TaskDao {
	public void create(Task task);

	public void update(Task task);

	public Task find(String id);
	public List<TaskVO> findBy(String id);
	public long countByTask(String id);
	
	public long countByTaskStatus(String id);
}
