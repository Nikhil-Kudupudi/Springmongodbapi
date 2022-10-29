package com.productapi.Springmongodbapi.Models;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProduct {

    public String email;
     
    public String Productid;
    public String Productname;
    
    public int Cost;
    public int Quantity;
    
    public String Companyname;

}
