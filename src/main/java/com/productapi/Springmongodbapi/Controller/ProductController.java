package com.productapi.Springmongodbapi.Controller;
import com.productapi.Springmongodbapi.Models.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.productapi.Springmongodbapi.Models.Userproducts;
import com.productapi.Springmongodbapi.Service.ProductService;

@CrossOrigin
@RestController
@RequestMapping()
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@PostMapping("/addproduct")
	@ResponseStatus(HttpStatus.CREATED)
	public String addproduct(@RequestBody Userproducts addproduct) {
		return service.addproducts(addproduct);
	}
	
	@PutMapping("/addnewproduct")
	public String addnewproduct(@RequestBody Userproducts product) {
		return service.addnewproduct(product);
	}
	
	@GetMapping("/productdetails/{email}")
	public Userproducts getproducts(@PathVariable String email ){
		return service.getproducts(email);
	}
	
}
