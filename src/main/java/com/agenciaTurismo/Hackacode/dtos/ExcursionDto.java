package com.agenciaTurismo.Hackacode.dtos;

public class ExcursionDto {
    private String name;
    private String descript;
    private String startDate;
    private Double price;
    private String destination;
    private Double duration;
    private String origin;


    public ExcursionDto() {
    }

    public ExcursionDto(String name, String descript, String startDate, Double price, String destination, Double duration, String origin) {
        this.name = name;
        this.descript = descript;
        this.startDate = startDate;
        this.price = price;
        this.destination = destination;
        this.duration = duration;
        this.origin = origin;
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

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getDuration() {
        return this.duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }



}
