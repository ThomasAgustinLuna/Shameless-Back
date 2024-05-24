package com.agenciaTurismo.Hackacode.dtos;

import com.agenciaTurismo.Hackacode.enums.TicketType;

public class TicketsDto {
    private String productCode;
    private String name;
    private String descript;
    private String startDate;
    private Double price;
    private TicketType ticketType;
    private String origin;
    private String destination;


    

    public TicketsDto() {
    }


    public TicketsDto(String productCode, String name, String descript, String startDate, Double price, TicketType ticketType, String origin, String destination) {
        this.productCode = productCode;
        this.name = name;
        this.descript = descript;
        this.startDate = startDate;
        this.price = price;
        this.ticketType = ticketType;
        this.origin = origin;
        this.destination = destination;
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

    public TicketType getTicketType() {
        return this.ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


}
