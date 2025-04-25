package com.example.RemoteJobsHub.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RemoteJobsHub.Entity.Application;
import com.example.RemoteJobsHub.Service.ApplicationService;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {
	
	@Autowired
	private ApplicationService applications;
	
	@PostMapping("Save")
	public Application SaveAll(@RequestBody Application application) {
		return applications.SaveAllApplications(application);
	}
	@GetMapping("All")
	public ResponseEntity<?>getAll(){
		List<Application>application=applications.getAll();
		if(application.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("given request is bad request");
		}
		else {
			return ResponseEntity.ok(application);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>getByid(@PathVariable Long id){
		Optional<Application>application=applications.geyById(id);
		if(application.isPresent()) {
			return ResponseEntity.ok(application.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("given id is not exists"+id);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteByid(@PathVariable Long id){
		boolean application=applications.deleteById(id);
		if(application) {
			return ResponseEntity.ok("given id is deleted Successfully"+id);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("given id is not deleted"+id);
		}
	}


}
