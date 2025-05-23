package com.example.RemoteJobsHub.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RemoteJobsHub.Entity.User;
import com.example.RemoteJobsHub.Service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("Save")
	public User saveUser(@RequestBody User users) {
		return userService.saveUsers(users);
	}
	
	
	@GetMapping("All")
	public ResponseEntity<?>getAll(){
		List<User>users=userService.getAllUsers();
		if(users.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Given body is Empty");
		}
		else {
			return ResponseEntity.ok(users);
		}
	}
	
	
	@GetMapping("/{id}")
		public ResponseEntity<?>getByid(@PathVariable Long id){
			Optional<User>users=userService.getById(id);
			if(users.isPresent()) {
				return ResponseEntity.ok(users.get());
						
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Given Id is Not Exists"+id);
			}
		}
	
	@GetMapping("/login/{first_name}/{contact}")
	public ResponseEntity<?> loginUser(@PathVariable String firstName, @PathVariable long contact) {
	    Optional<User> user = userService.getAllUsers().stream()
	        .filter(u -> u.getFirstName().equalsIgnoreCase(firstName) && u.getContact() == contact)
	        .findFirst();

	    if (user.isPresent()) {
	        return ResponseEntity.ok(user.get()); // Return the user object if login is successful
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login credentials");
	    }
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteByid(@PathVariable Long id){
		boolean users=userService.deleteById(id);
		if(users) {
			return ResponseEntity.ok("deleted Successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("given id is not deleted");
		}
	}
	}


