package com.cts.projectmanager.vo;

import java.util.Date;
import java.util.List;

import com.cts.projectmanager.mongo.model.ParentTask;

public class TaskVO {

	private String taskId;
	private String taskName;
	private int priority;
	private Date startDate;
	private Date endDate;	
	private String status;
	private Character isParentTask;
	private String parentTaskId;
	private String projId;
	private String empId;
	private String parentTask;
	private String projectName;
	private List<ParentTask> parenttasks;


	public TaskVO() {
		
	}
	public TaskVO(String taskId, String taskName, int priority, Date startDate, Date endDate, String status,
			Character isParentTask, String parentTaskId, String projId, String empId) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.priority = priority;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.isParentTask = isParentTask;
		this.parentTaskId = parentTaskId;
		this.projId = projId;
		this.empId = empId;
	}
	
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
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
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getParentTask() {
		return parentTask;
	}
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getParentTaskId() {
		return parentTaskId;
	}
	public void setParentTaskId(String parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	public List<ParentTask> getParenttasks() {
		return parenttasks;
	}
	public void setParenttasks(List<ParentTask> parenttasks) {
		this.parenttasks = parenttasks;
	}
	public Character getIsParentTask() {
		return isParentTask;
	}
	public void setIsParentTask(Character isParentTask) {
		this.isParentTask = isParentTask;
	}
	
}
