package com.productapi.Springmongodbapi.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
	@Id
	public String userId;
	
	public String username;
	
	public String email;
	
	public String Phone;
	
	public String Address;
	
	public String password;

	
}
