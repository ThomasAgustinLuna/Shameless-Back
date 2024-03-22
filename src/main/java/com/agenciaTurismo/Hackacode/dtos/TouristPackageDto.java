package com.agenciaTurismo.Hackacode.dtos;

public class TouristPackageDto {
    private String name;
    private String descript;
    private String startDate;
    private Double price;
    private String car;
    private String hotel;
    private String event;
    private String excursion;
    private String ticket;




    public TouristPackageDto() {
    }


    public TouristPackageDto(String name, String descript, String startDate, Double price, String car, String hotel, String event, String excursion, String ticket) {
        this.name = name;
        this.descript = descript;
        this.startDate = startDate;
        this.price = price;
        this.car = car;
        this.hotel = hotel;
        this.event = event;
        this.excursion = excursion;
        this.ticket = ticket;
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

    public String getCar() {
        return this.car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getHotel() {
        return this.hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getExcursion() {
        return this.excursion;
    }

    public void setExcursion(String excursion) {
        this.excursion = excursion;
    }

    public String getTicket() {
        return this.ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    
    
}
