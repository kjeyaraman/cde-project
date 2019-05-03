package com.cts.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanager.service.ProjectService;
import com.cts.projectmanager.vo.ProjectVO;

@RestController
@RequestMapping("/projectService")
@CrossOrigin("*")
public class ProjectController {

	@Autowired
	@Qualifier("projectService")
	ProjectService projectService;


	@GetMapping("/projects")
	public ResponseEntity<List<ProjectVO>>  getProjectList() {
		return new ResponseEntity<List<ProjectVO>>(projectService.getProjectList(), HttpStatus.OK);
	}

	@PostMapping("/edit")
	public ResponseEntity<ProjectVO> updateProject(@RequestBody ProjectVO project) {
		projectService.updateProject(project);
		return new ResponseEntity<ProjectVO>(project, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addProject(@RequestBody ProjectVO project) {
		projectService.addProject(project);
		return new ResponseEntity<>(project.getProjId(), HttpStatus.OK);
	}

	
	
}
