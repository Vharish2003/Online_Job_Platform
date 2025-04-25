package com.example.RemoteJobsHub.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RemoteJobsHub.Entity.Company;
import com.example.RemoteJobsHub.Repository.CompanyRepo;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepo companyRepo;
	
	
	public Company saveCompany(Company company) {
		return companyRepo.save(company);
	}
	
	public List<Company>getAll(){
		return companyRepo.findAll();
	}
	public Optional<Company>getById(Long id){
		return companyRepo.findById(id);
	}
	public boolean deleteById(Long id) {
	       if(companyRepo.existsById(id)) {
	    	   companyRepo.deleteById(id);
	    	   return true;
	       }
	       else {
	    	   return false;
	       }
	}

}
