package com.cts.projectmanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanager.exception.RecordNotFoundException;
import com.cts.projectmanager.mongo.model.User;
import com.cts.projectmanager.service.UserService;



@RestController
@RequestMapping("/userservice")
@CrossOrigin("*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	@Qualifier("userService")
	UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userService.getUserList(), HttpStatus.OK);
	}

	@PostMapping("/edit")
	public ResponseEntity<User> modifyUser(@RequestBody User user) throws RecordNotFoundException {
		userService.editUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		logger.info("User to be Added {}.", user.toString());
		userService.addUser(user);
		return new ResponseEntity<>(user.getId(), HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<User> searchUser(@PathVariable String id) throws RecordNotFoundException {
		logger.info("User to be searched {}.", id);

		User user = userService.findUser(id);
		if(user == null) {
	         throw new RecordNotFoundException("Invalid employee id");
	    }
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) throws RecordNotFoundException {
		logger.info("User to be Deleted {}.", id);
		userService.removeUser(id);
		return new ResponseEntity<>("Success!", HttpStatus.OK);
	}
}
