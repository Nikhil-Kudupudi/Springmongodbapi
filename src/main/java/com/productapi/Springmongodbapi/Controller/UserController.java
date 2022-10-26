package com.productapi.Springmongodbapi.Controller;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.productapi.Springmongodbapi.Models.User;
import com.productapi.Springmongodbapi.Models.login;
import com.productapi.Springmongodbapi.Service.UserService;



@CrossOrigin
@RestController
@RequestMapping()
public class UserController {
@Autowired
private UserService service;

@PostMapping("/user")
public String createUser(@RequestBody User user) { 
return service.addUser(user);}

@PostMapping("/login")
@ResponseStatus(HttpStatus.CREATED)
public String loginUser(@RequestBody login user) {
	return service.checkUser(user);
}

@PostMapping("/getdetails")
public User getdetails(@RequestBody login user) {
	
	return service.getdetails(user.email);
}


}
