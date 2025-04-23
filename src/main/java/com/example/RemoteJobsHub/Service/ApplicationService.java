package com.example.RemoteJobsHub.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RemoteJobsHub.Entity.Application;
import com.example.RemoteJobsHub.Repository.ApplicationRepo;

@Service
public class ApplicationService {
	
	@Autowired
	private ApplicationRepo applicationRepo;
	
	public Application SaveAllApplications(Application application) {
		return applicationRepo.save(application);
	}
		public List<Application>getAll(){
			return applicationRepo.findAll();
		
	}
		public Optional<Application>geyById(Long id){
			return applicationRepo.findById(id);
		}
		
		public boolean deleteById(Long id) {
			if(applicationRepo.existsById(id)) {
				applicationRepo.deleteById(id);
				return true;
			}
			else {
				return false;
			}
		}

}
