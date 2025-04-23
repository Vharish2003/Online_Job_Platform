package com.example.RemoteJobsHub.Service;

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
	

}
