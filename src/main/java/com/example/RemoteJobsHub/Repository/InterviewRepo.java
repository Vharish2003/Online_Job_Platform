package com.example.RemoteJobsHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RemoteJobsHub.Entity.Interview;

@Repository
public interface InterviewRepo extends JpaRepository<Interview, Long>{

}
