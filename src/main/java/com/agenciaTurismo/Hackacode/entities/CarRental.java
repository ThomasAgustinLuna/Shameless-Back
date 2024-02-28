package com.agenciaTurismo.Hackacode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
public class CarRental extends Product {

    String carType;
    @Temporal(TemporalType.DATE)
    Date deadlineDate;

    public CarRental() {
    }

    public CarRental(String carType, Date deadlineDate, String productCode, String name, String descript,
            Date startDate, Double price, boolean status) {
        super(productCode, name, descript, startDate, price, status);
        this.carType = carType;
        this.deadlineDate = deadlineDate;
    }

    public String getCarType() {
        return this.carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Date getDeadlineDate() {
        return this.deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

}
