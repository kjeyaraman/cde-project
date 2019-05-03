package com.cts.projectmanager.service;

import java.util.List;

import com.cts.projectmanager.mongo.model.ParentTask;
import com.cts.projectmanager.vo.TaskVO;

public interface TaskService {


	public List<ParentTask> getParentTaskList();
	

	public void createTask(TaskVO task);

	public void editTask(TaskVO task);

	public List<TaskVO> getTaskListByProjectId(String Id);

}
