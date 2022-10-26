package com.productapi.Springmongodbapi.Models;

import org.springframework.data.annotation.Id;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	public String Productid;
	public String Productname;
	
	public int Cost;
	public int Quantity;
	
	public String Companyname;

}
