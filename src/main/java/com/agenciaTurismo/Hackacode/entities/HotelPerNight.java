package com.agenciaTurismo.Hackacode.entities;

import java.util.Date;
import jakarta.persistence.Entity;

@Entity
public class HotelPerNight extends Product {

    private String ubication;
    private Integer numbOfRooms;

    public HotelPerNight() {
    }

    public HotelPerNight(String ubication, Integer numbOfRooms, String productCode, String name, String descript,
            Date startDate, Double price, boolean status) {
        super(productCode, name, descript, startDate, price, status);
        this.ubication = ubication;
        this.numbOfRooms = numbOfRooms;
    }

    public String getUbication() {
        return this.ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public Integer getNumbOfRooms() {
        return this.numbOfRooms;
    }

    public void setNumbOfRooms(Integer numbOfRooms) {
        this.numbOfRooms = numbOfRooms;
    }

}
