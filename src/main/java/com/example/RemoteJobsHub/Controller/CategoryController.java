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

import com.example.RemoteJobsHub.Entity.JobCategory;
import com.example.RemoteJobsHub.Service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("Save")
	public JobCategory saveAll(@RequestBody JobCategory category) {
		return categoryService.SaveAll(category);
	}
	
	@GetMapping("All")
	public ResponseEntity<?>getAll(){
		List<JobCategory>category=categoryService.getAll();
		if(category.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("given request is not exists");
		}
		else {
			return ResponseEntity.ok(category);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getByid(@PathVariable Long id){
		Optional<JobCategory>category=categoryService.getById(id);
		if(category.isPresent()) {
			return ResponseEntity.ok(category.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("given id is not exists"+id);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteByid(@PathVariable Long id){
		boolean category=categoryService.deleteById(id);
		if(category) {
			return ResponseEntity.ok("given id is successfully deleted"+id);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("given id is not deleted"+id);
		}
	}
	

}
