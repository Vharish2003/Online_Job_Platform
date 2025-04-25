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

import com.example.RemoteJobsHub.Entity.Company;
import com.example.RemoteJobsHub.Service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("Save")
	public Company saveAll(@RequestBody Company company) {
		return companyService.saveCompany(company);
	}
	
	@GetMapping("All")
	public ResponseEntity<?>getAll(){
		List<Company>company=companyService.getAll();
		if(company.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("given Request is Not Exists");
		}
		else {
			return ResponseEntity.ok(company);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getByid(@PathVariable Long id){
		Optional<Company>company=companyService.getById(id);
		if(company.isPresent()) {
			return ResponseEntity.ok(company.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("given id is not exists"+id);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteByid(@PathVariable Long id){
		boolean company=companyService.deleteById(id);
		if(company) {
			return ResponseEntity.ok("deleted Successfully"+id);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("given id is not deleted");
		}
	}
}
