package com.cts.projectmanager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.projectmanager.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagerApplicationTest {
	
	 @Autowired
	    private UserController userController;
	 
	 
	@Test
	public void contextLoads() {
	}
	
	@Test
	  public void appStart() {
		assertThat(userController).isNotNull();
	  }
	
	public static String getRandomId(){
	    Random rand = new Random(); 
		int num = rand.nextInt(9000000) + 1000000;
		return Integer.toString(num);
		
		}
}
