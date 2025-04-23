package com.example.RemoteJobsHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RemoteJobsHub.Entity.JobCategory;

@Repository
public interface CategoryRepo extends JpaRepository<JobCategory, Long> {

}
