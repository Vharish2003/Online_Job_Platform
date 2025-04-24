package com.example.RemoteJobsHub.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RemoteJobsHub.Entity.Job;
import com.example.RemoteJobsHub.Repository.JobRepo;

@Service
public class JobService {
	
	@Autowired
	private JobRepo jobRepo;
	
	public Job saveAllJobs(Job jobs) {
		return jobRepo.save(jobs);
	}
	public List<Job>getAllJobs(){
		return jobRepo.findAll();
	}
	public Optional<Job>getById(Long id){
		return jobRepo.findById(id);
	}
	public boolean deleteById(Long id) {
		if(jobRepo.existsById(id)) {
			jobRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

	public Job updateJob(Long id, Job updatejob) {
		Job jobs=jobRepo.findById(id).orElse(null);
		if(jobs !=null) {
		jobs.setTitle(updatejob.getTitle());
		jobs.setCompany(updatejob.getCompany());
		jobs.setDescription(updatejob.getDescription());
		jobs.setEmp_type(updatejob.getEmp_type());
		jobs.setLocation(updatejob.getLocation());
		jobs.setSalary(updatejob.getSalary());
		jobs.setSkills(updatejob.getSkills());
		jobs.setJobcategory(updatejob.getJobcategory());
		return jobRepo.save(updatejob);
		}
		else {
			return null;
		}
	}
}
