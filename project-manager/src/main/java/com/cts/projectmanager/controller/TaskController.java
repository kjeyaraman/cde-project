package com.cts.projectmanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanager.mongo.model.ParentTask;
import com.cts.projectmanager.service.TaskService;
import com.cts.projectmanager.vo.TaskVO;

@RestController
@RequestMapping("/taskService")
@CrossOrigin("*")
public class TaskController {

	@Autowired
	@Qualifier("taskService")
	TaskService taskService;
	

	@GetMapping("/parentTasks")
	public ResponseEntity<List<ParentTask>> getParentTaskList() {
		return new ResponseEntity<List<ParentTask>>(taskService.getParentTaskList(), HttpStatus.OK);

	}

	@GetMapping("/tasks/{id}")
	public ResponseEntity<List<TaskVO>> getTaskListByProjectId(@PathVariable String id ) {
		return new ResponseEntity<List<TaskVO>>(taskService.getTaskListByProjectId(id), HttpStatus.OK);
	}

	@PostMapping("/addTask")
	public ResponseEntity<String> addTask(@RequestBody TaskVO task) {
		taskService.createTask(task);
		return new ResponseEntity<>(task.getTaskId(), HttpStatus.OK);
	}

	@PostMapping("/editTask")
	public ResponseEntity<TaskVO> updateTask(@Valid @RequestBody TaskVO task) {
		taskService.editTask(task);
		return new ResponseEntity<TaskVO>(task, HttpStatus.OK);
	}

}
