package com.example.RemoteJobsHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RemoteJobsHub.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
