package com.productapi.Springmongodbapi.Models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "user")
public class login{
	public String email;
	public String password;
	
}