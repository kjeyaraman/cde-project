package com.cts.projectmanager;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cts.projectmanager.vo.ProjectVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProjectControllerTest extends ProjectManagerApplicationTest {
	
	private static final String PROJ_ID = getRandomId();

	@Autowired
	WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public  void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void getProjectList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/projectService/projects").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].projId").exists());
	}
	

	
	@Test
	
	public void addProject() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/projectService/add")
	      .content(asJsonString(new ProjectVO(PROJ_ID, "test Project2",10,new Date(),new Date(),"789789"))).contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON)).andDo(print())
	      .andExpect(status().isOk());
	}
	
	
	@Test
	
	public void updateProject() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/projectService/edit")
	      .content(asJsonString(new ProjectVO("123456", "test Project4",6,new Date(),new Date(),"212127"))).contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON)).andDo(print())
	      .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.projId").value("123456"));
	}
	

	
	public static String asJsonString(final Object obj) {
	    try {
	    	
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }


}}
