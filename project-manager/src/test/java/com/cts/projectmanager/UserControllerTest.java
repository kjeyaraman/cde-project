package com.cts.projectmanager;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cts.projectmanager.mongo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserControllerTest extends ProjectManagerApplicationTest {
	


	private static final String USER_ID = getRandomId();

	@Autowired
	WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public  void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void getUsers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/userservice/users").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].empId").exists());
		

	}
	

	

	@Test
	public void searchUser() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders.get("/userservice/find/{id}", 203527) )
        .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.empId").value("203527"));
	}
	
	
	@Test
	public void searchUserNotfound() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders.get("/userservice/find/{id}", 203526) )
        .andExpect(status().isNotFound());
	}
	
	
	
	@Test
	public void addUser() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/userservice/add")
	      .content(asJsonString(new User(USER_ID, "firstName1", "lastName1"))).contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON)).andDo(print())
	      .andExpect(status().isOk());
	}
	
	
	@Test
	public void editUser() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/userservice/edit")
	      .content(asJsonString(new User("111111", "firstName8", "lastName8"))).contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON)).andDo(print())
	      .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.empId").value("111111"));
	}
	
	
	
	
	@Test
	
	public void deleteAvailableUser() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders.delete("/userservice/delete/{id}", USER_ID) )
        .andExpect(status().isOk());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	    	
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	    
		


}
	

	
}
