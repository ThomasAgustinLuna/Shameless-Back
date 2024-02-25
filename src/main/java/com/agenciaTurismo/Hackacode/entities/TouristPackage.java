package com.agenciaTurismo.Hackacode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Entity
public class TouristPackage extends Product {

    @ManyToMany
    private List<Product> products;

    public TouristPackage() {
    }

    public TouristPackage(List<Product> products, String productCode, String name, String descript, Date startDate,
            Double price, boolean status) {
        super(productCode, name, descript, startDate, price, status);
        this.products = products;
        this.price = price;
        this.status = status;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
