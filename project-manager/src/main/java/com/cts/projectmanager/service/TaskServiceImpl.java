package com.cts.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanager.dao.ParentTaskRepository;
import com.cts.projectmanager.dao.TaskRepository;
import com.cts.projectmanager.dao.UserRepository;
import com.cts.projectmanager.mongo.model.ParentTask;
import com.cts.projectmanager.mongo.model.Task;
import com.cts.projectmanager.mongo.model.User;
import com.cts.projectmanager.vo.TaskVO;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	ParentTaskRepository parentTaskRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public List<ParentTask> getParentTaskList() {
		return parentTaskRepository.findAll();
	}

	@Override
	public void createTask(TaskVO task) {
		if (task != null) {
			if (task.getIsParentTask().equals('Y')) {
				ParentTask parentTask = new ParentTask();
				parentTask.setParentTaskId(task.getTaskId());
				parentTask.setParentTaskName(task.getTaskName());
				parentTaskRepository.create(parentTask);
				return;
			}
			Task childTask = new Task();
			childTask.setTaskName(task.getTaskName());
			childTask.setStartDate(task.getStartDate());
			childTask.setEndDate(task.getEndDate());
			childTask.setPriority(task.getPriority());
			childTask.setStatus(task.getStatus());
			childTask.setParentTaskId(task.getParentTaskId());
			childTask.setProjId(task.getProjId());
			childTask.setTaskId(task.getTaskId());
			taskRepository.create(childTask);
			User user = userRepository.find(task.getEmpId());
			user.setTaskId(childTask.getTaskId());
			userRepository.update(user);

		}

	}

	@Override
	public void editTask(TaskVO task) {
		Task childTask = taskRepository.find(task.getTaskId());
		childTask.setTaskName(task.getTaskName());
		childTask.setStartDate(task.getStartDate());
		childTask.setEndDate(task.getEndDate());
		childTask.setPriority(task.getPriority());
		childTask.setStatus(task.getStatus());
		if (task.getParentTaskId() != childTask.getParentTaskId()) {
			childTask.setParentTaskId(task.getParentTaskId());
		}
		taskRepository.update(childTask);
		User user = userRepository.find(task.getEmpId());
		user.setTaskId(childTask.getTaskId());
		userRepository.update(user);

	}

	@Override
	public List<TaskVO> getTaskListByProjectId(String id) {
		List<TaskVO> taskList = taskRepository.findBy(id);
		return taskList;
	}

}
