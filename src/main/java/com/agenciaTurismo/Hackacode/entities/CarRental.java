package com.agenciaTurismo.Hackacode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
public class CarRental extends Product {

    String carType;
    @Temporal(TemporalType.DATE)
    Date deadLineDate;

    public CarRental() {
    }

    public CarRental(String carType, Date deadLineDate, String productCode, String name, String descript,
            Date startDate, Double price, boolean status) {
        super(productCode, name, descript, startDate, price, status);
        this.carType = carType;
        this.deadLineDate = deadLineDate;
    }

    public String getCarType() {
        return this.carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Date getDeadLineDate() {
        return this.deadLineDate;
    }

    public void setDeadLineDate(Date deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

}
