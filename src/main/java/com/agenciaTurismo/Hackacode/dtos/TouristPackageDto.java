package com.agenciaTurismo.Hackacode.dtos;

public class TouristPackageDto {
    private String name;
    private String descript;
    private String startDate;
    private Double price;
    private String products;


    public TouristPackageDto() {
    }


    public TouristPackageDto(String name, String descript, String startDate, Double price, String products) {
        this.name = name;
        this.descript = descript;
        this.startDate = startDate;
        this.price = price;
        this.products = products;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return this.descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProducts() {
        return this.products;
    }

    public void setProducts(String products) {
        this.products = products;
    }


    
}
