package com.agenciaTurismo.Hackacode.entities;

import jakarta.persistence.Entity;
import java.util.List;
import java.util.Date;

@Entity
public class TouristPackage extends Product{

    private List <Product> products;
    
    
    public TouristPackage() {
    }
    
    public TouristPackage(List<Product> products, String productCode, String name, String descript, Date startDate, Double price, boolean status) {
        super(productCode, name, descript, startDate, price, status); 
        this.products = products;
        
    }
    
    public List<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    

}
