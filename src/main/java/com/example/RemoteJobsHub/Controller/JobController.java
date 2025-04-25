package com.example.RemoteJobsHub.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RemoteJobsHub.Entity.Job;
import com.example.RemoteJobsHub.Service.JobService;


@RestController
@RequestMapping("/api/jobs")
public class JobController {
	
	@Autowired
	private JobService jobService;

	@PostMapping("Save")
	public Job saveJob(@RequestBody Job jobs) {
		return jobService.saveAllJobs(jobs);
	}
	
	@GetMapping("All")
	public ResponseEntity<?>getAll(){
		List<Job>jobs=jobService.getAllJobs();
		if(jobs.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Given request is not accepted");
		}
		else {
			return ResponseEntity.ok(jobs);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getByid(@PathVariable Long id){
		Optional<Job>jobs=jobService.getById(id);
		if(jobs.isPresent()) {
			return ResponseEntity.ok(jobs.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("given id is not exists"+id);
			
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteByid(@PathVariable Long id){
		boolean jobs=jobService.deleteById(id);
		if(jobs) {
			return ResponseEntity.ok("deleted successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("given id is not deleted"+id);
		}
	}
	@PutMapping("/{id}")
    public ResponseEntity<?>updateByJob(@RequestBody Job jobs, @PathVariable Long id){
		Job updatejobs=jobService.updateJob(id, jobs);
		if(updatejobs !=null) {
			return ResponseEntity.ok(updatejobs);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("job id is not found"+id);
		}
	}
	
}
