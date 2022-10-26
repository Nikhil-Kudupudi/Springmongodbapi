package com.productapi.Springmongodbapi.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapi.Springmongodbapi.Models.Userproducts;

@Repository
public interface ProductRepository extends MongoRepository<Userproducts,String>{

	@Query("{email:?0}")
	Userproducts findByEmail(String email);
// 
	
	
	
	

}
