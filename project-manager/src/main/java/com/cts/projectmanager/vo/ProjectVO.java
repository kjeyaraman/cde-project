package com.cts.projectmanager.vo;

import java.util.Date;

public class ProjectVO {


	public ProjectVO() {
		
	}
	private String projId;
	private String projectName;
	private int priority;
	private Date startDate;
	private Date endDate;
	private String projectManager;
	private long taskCount;
	private long completedTaskCount;

	
	public ProjectVO(String projId, String projectName, int priority, Date startDate, Date endDate,
			String projectManager) {
		super();
		this.projId = projId;
		this.projectName = projectName;
		this.priority = priority;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectManager = projectManager;
	}
	
	
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	public long getTaskCount() {
		return taskCount;
	}
	public void setTaskCount(long taskCount) {
		this.taskCount = taskCount;
	}
	public long getCompletedTaskCount() {
		return completedTaskCount;
	}
	public void setCompletedTaskCount(long completedTaskCount) {
		this.completedTaskCount = completedTaskCount;
	}

	
}
