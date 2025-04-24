package com.example.RemoteJobsHub.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RemoteJobsHub.Entity.Interview;
import com.example.RemoteJobsHub.Repository.InterviewRepo;

@Service
public class InterviewService {
	
	@Autowired
	private InterviewRepo interviewRepo;
	
	public Interview saveInterview(Interview interview) {
		return interviewRepo.save(interview);
	}
	
	public List<Interview>getAll(){
		return interviewRepo.findAll();
	}
	public Optional<Interview>getByid(Long id){
		return interviewRepo.findById(id);
	}
	
	public boolean deleteById(Long id) {
		if(interviewRepo.existsById(id)) {
			interviewRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

}
