package com.cts.projectmanager.service;

import java.util.List;

import com.cts.projectmanager.vo.ProjectVO;

public interface ProjectService {

	public void addProject(ProjectVO project);

	public void updateProject(ProjectVO project);
	
	public List<ProjectVO> getProjectList();
}
