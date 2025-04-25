package com.example.RemoteJobsHub.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RemoteJobsHub.Entity.Interview;
import com.example.RemoteJobsHub.Service.InterviewService;


@RestController
@RequestMapping("/api/interview")
public class InterviewController {
	
	@Autowired
	private InterviewService interviewService;
	
	@PostMapping("Save")
	public Interview saveInterview(@RequestBody Interview interview) {
		return interviewService.saveInterview(interview);
	}
	
	@GetMapping("All")
	public ResponseEntity<?>getAllinterview(){
		List<Interview>interview=interviewService.getAll();
		if(interview.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("given request is not exists");
		}
		else {
			return ResponseEntity.ok(interview);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>getByid(@PathVariable Long id){
		Optional<Interview>interview=interviewService.getByid(id);
		if(interview.isPresent()) {
			return ResponseEntity.ok(interview.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("given id is not exists"+id);
		}
	}

}
