package com.agenciaTurismo.Hackacode.entities;

import jakarta.persistence.Entity;
import java.util.Date;

@Entity
public class Excursion extends Product {

    private String destination;
    private Double duration;

    public Excursion() {
    }

    public Excursion(String destination, Double duration, String productCode, String name, String descript,
            Date startDate, Double price, boolean status) {
        super(productCode, name, descript, startDate, price, status);
        this.destination = destination;
        this.duration = duration;
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

}
