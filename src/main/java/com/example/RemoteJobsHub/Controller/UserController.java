package com.example.RemoteJobsHub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RemoteJobsHub.Entity.User;
import com.example.RemoteJobsHub.Service.UserService;

@Controller
@RestController("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("Save")
	public User saveUser(@RequestBody User users) {
		return userService.saveUsers(users);
	}

}
