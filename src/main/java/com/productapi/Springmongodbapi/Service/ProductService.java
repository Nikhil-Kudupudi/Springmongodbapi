package com.productapi.Springmongodbapi.Service;

import com.productapi.Springmongodbapi.Models.*;

import java.util.List;
import java.util.UUID;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapi.Springmongodbapi.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public String addproducts(Userproducts Addproduct) {
		
		Userproducts checkdata=repository.findByEmail(Addproduct.email);
		
		System.out.println(checkdata);
		
		if(checkdata!=null) {
			if(checkdata.email==Addproduct.email)
				System.out.println(checkdata);
				return "User Exists";
			
		}
		
		Addproduct.setEmailid(UUID.randomUUID().toString().split("-")[0]);
		 repository.save(Addproduct);
		 return "created";
	}
	
	public String addnewproduct(Userproducts Addproduct) {
		System.out.println(Addproduct.email);
		Userproducts user=repository.findByEmail(Addproduct.email);
		System.out.println(user);
		if(user==null) {
			repository.save(Addproduct);
			return "added";
		}
		List<Item> item=user.getProduct();
		item.addAll(Addproduct.product);
		
	  	repository.save(user);
		return "success";
	}
	
	public Userproducts getproducts(String email) {
		Userproducts user=repository.findByEmail(email);
		return user;
		
	}



}
