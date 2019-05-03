package com.cts.projectmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanager.dao.ProjectRepository;
import com.cts.projectmanager.dao.TaskRepository;
import com.cts.projectmanager.dao.UserRepository;
import com.cts.projectmanager.mongo.model.Project;
import com.cts.projectmanager.mongo.model.User;
import com.cts.projectmanager.vo.ProjectVO;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	public void addProject(ProjectVO project) {
		
		Project proj= new Project();
		proj.setProjId(project.getProjId());
		proj.setProjectName(project.getProjectName());
		proj.setPriority(project.getPriority());
		proj.setStartDate(project.getStartDate());
		proj.setEndDate(project.getEndDate());
		projectRepository.create(proj);
		User user = userRepository.find(project.getProjectManager());
		user.setProjId(project.getProjId());
		userRepository.update(user);

	}

	@Override
	public void updateProject(ProjectVO project) {
		
		Project proj=projectRepository.find(project.getProjId());
		proj.setProjectName(project.getProjectName());
		proj.setPriority(project.getPriority());
		proj.setStartDate(project.getStartDate());
		proj.setEndDate(project.getEndDate());
		projectRepository.update(proj);
		User user = userRepository.find(project.getProjectManager());
		user.setProjId(project.getProjId());
		userRepository.update(user);

	}


	@Override
	public List<ProjectVO> getProjectList() {
		List<Project> projList= projectRepository.findAll();
		List<ProjectVO> projectVOList=new ArrayList<ProjectVO>();
		for(Project project :projList){
			ProjectVO proj = new ProjectVO();
			proj.setProjId(project.getProjId());
			proj.setProjectName(project.getProjectName());
			proj.setPriority(project.getPriority());
			proj.setStartDate(project.getStartDate());
			proj.setEndDate(project.getEndDate());
			proj.setTaskCount(taskRepository.countByTask(project.getProjId()));
			proj.setCompletedTaskCount(taskRepository.countByTaskStatus(project.getProjId()));
			projectVOList.add(proj);
		}		 
		 return projectVOList;
	}

	

}
