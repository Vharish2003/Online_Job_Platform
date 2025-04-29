package com.example.RemoteJobsHub.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RemoteJobsHub.Entity.User;
import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	Optional<User>findByFirstNameAndContact(String firstName, long contact);


}
