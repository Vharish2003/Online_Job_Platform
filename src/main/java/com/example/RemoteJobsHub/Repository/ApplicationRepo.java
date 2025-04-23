package com.example.RemoteJobsHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RemoteJobsHub.Entity.Application;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {

}
