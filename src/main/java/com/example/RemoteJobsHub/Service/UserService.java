package com.example.RemoteJobsHub.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RemoteJobsHub.Entity.User;
import com.example.RemoteJobsHub.Repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User saveUsers(User user) {
		return userRepo.save(user);
	}
	
	public List<User>getAllUsers(){
		return userRepo.findAll();
	}
	public Optional<User>getById(Long id){
		return userRepo.findById(id);
	}
	public Optional<User> loginUser(String firstName, long contact) {
        return userRepo.findByFirstNameAndContact(firstName, contact);
    }
	public boolean deleteById(Long id){
		if(userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

}
