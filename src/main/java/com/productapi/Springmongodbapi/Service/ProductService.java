package com.productapi.Springmongodbapi.Service;

import com.productapi.Springmongodbapi.Models.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;


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
	
	public String updateproduct(UpdateProduct productdetail) {
	    Userproducts user=repository.findByEmail(productdetail.email);
	     Item prod = new Item();
	     int count=0;
        
        for(Item item:user.product){
            System.out.println("hello "+item.Productid);
	        if (item.Productid.equals(productdetail.Productid)){
	            System.out.println(item.Productid);
	            prod.setProductid(productdetail.Productid);
	          prod.setProductname(productdetail.Productname);
	          prod.setCost(productdetail.Cost);
	          prod.setQuantity(productdetail.Quantity);
	          prod.setCompanyname(productdetail.Companyname);
	          List<Item> ite=user.getProduct();
	          item=prod;
	           
	          System.out.println(count);
	          ite.set(count, prod);
	          repository.save(user);
	          return "success";
	        }
	        count++;
	    }
	    return "failed";
	}
	



}
