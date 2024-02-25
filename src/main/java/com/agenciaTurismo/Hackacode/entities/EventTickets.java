package com.agenciaTurismo.Hackacode.entities;

import jakarta.persistence.Entity;
import java.util.Date;

@Entity
public class EventTickets extends Product {
    private String ubication;
    private Double duration;

    public EventTickets() {
    }

    public EventTickets(String ubication, Double duration, String productCode, String name, String descript,
            Date startDate, Double price, boolean status) {
        super(productCode, name, descript, startDate, price, status);
        this.ubication = ubication;
        this.duration = duration;
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
