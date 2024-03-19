package com.agenciaTurismo.Hackacode.dtos;

public class CarRentalDto {
    private String productCode;
    private String name;
    private String descript;
    private String startDate;
    private Double price;
    private String carType;
    private String deadlineDate;


    public CarRentalDto() {
    }


    public CarRentalDto(String productCode, String name, String descript, String startDate, Double price, String carType, String deadlineDate) {
        this.productCode= productCode;
        this.name = name;
        this.descript = descript;
        this.startDate = startDate;
        this.price = price;
        this.carType = carType;
        this.deadlineDate = deadlineDate;
        
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public String getCarType() {
        return this.carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getDeadlineDate() {
        return this.deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

}
