package com.agenciaTurismo.Hackacode.dtos;

public class EventTicketsDto {
    private String productCode;
    private String name;
    private String descript;
    private String startDate;
    private Double price;
    private String ubication;
    private Double duration;



    public EventTicketsDto() {
    }


    public EventTicketsDto(String productCode, String name, String descript, String startDate, Double price, String ubication, Double duration) {
        this.productCode = productCode;
        this.name = name;
        this.descript = descript;
        this.startDate = startDate;
        this.price = price;
        this.ubication = ubication;
        this.duration = duration;
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

    public String getUbication() {
        return this.ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public Double getDuration() {
        return this.duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }
    

}
