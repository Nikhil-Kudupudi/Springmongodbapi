package com.productapi.Springmongodbapi.Service;



import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.productapi.Springmongodbapi.Models.User;
import com.productapi.Springmongodbapi.Models.login;
import com.productapi.Springmongodbapi.Repository.UserRepository;



@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	
	public String addUser(User user){
		user.setUserId(UUID.randomUUID().toString().split("-")[0]);
		
		  User check=repository.findByEmail(user.email); if(check!=null) { return
		  "User Already exist"; }
		 
		 repository.save(user);
		 return "success";
		 
	}
	
	public String checkUser(login user) {
		User check=repository.findByEmailandpassword(user.email,user.password);
		if(check!=null ) {
			return "success";
		}
	return "Does not exist";
	}
	
	public User getdetails(String email) {
		return repository.findByEmail(email);
		
	}
	
	
	
	
	
	

}
