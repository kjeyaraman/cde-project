package com.cts.projectmanager;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cts.projectmanager.mongo.model.User;
import com.cts.projectmanager.vo.ProjectVO;
import com.cts.projectmanager.vo.TaskVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TaskControllerTest extends ProjectManagerApplicationTest {
	
	private static final String TASK_ID = getRandomId();

	@Autowired
	WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public  void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void getParentTaskList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/taskService/parentTasks").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].parentTaskId").exists());
	}
	

	
	@Test
	public void getTaskListByProjectId() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders.get("/taskService/tasks/{id}", 123456) )
        .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].projId").value("123456"));
	}
	

	
	
	
	@Test
	
	public void addTask() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/taskService/addTask")
	      .content(asJsonString(new TaskVO(TASK_ID,"task1",10,new Date(),new Date(),"WIP",'N',"PTASK6","123456","789789"))).contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON)).andDo(print())
	      .andExpect(status().isOk());
	}
	
	@Test
	public void addParentTask() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/taskService/addTask")
	      .content(asJsonString(new TaskVO(TASK_ID,"task1",10,new Date(),new Date(),"WIP",'Y',"PTASK6","123456","789789"))).contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON)).andDo(print())
	      .andExpect(status().isOk());
	}
	
	
	@Test
	
	public void updateTask() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/taskService/editTask")
	      .content(asJsonString(new TaskVO("TASK1","task desc 3",10,new Date(),new Date(),"WIP",'N',"PTASK6","123456","789789"))).contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON)).andDo(print())
	      .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.taskId").value("TASK1"));
	}
	

	
	public static String asJsonString(final Object obj) {
	    try {
	    	
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }


}}
