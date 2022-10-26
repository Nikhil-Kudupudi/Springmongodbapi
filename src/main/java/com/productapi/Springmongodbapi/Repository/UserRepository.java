package com.productapi.Springmongodbapi.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.productapi.Springmongodbapi.Models.User;
public interface UserRepository extends MongoRepository<User,String> {
	@Query("{email:?0}")
	User findByEmail(String email);
	
	@Query("{email:?0,password:?1}")
	User findByEmailandpassword(String email, String password);
}
