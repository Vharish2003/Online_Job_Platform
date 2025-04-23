package com.example.RemoteJobsHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RemoteJobsHub.Entity.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Long>{

}
