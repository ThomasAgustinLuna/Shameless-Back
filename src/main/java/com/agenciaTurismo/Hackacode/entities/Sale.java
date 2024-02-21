package com.agenciaTurismo.Hackacode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import com.agenciaTurismo.Hackacode.enums.PaymentType;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleNumber;
    private Date saleDate;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Employee employee;
    private boolean status;
    private PaymentType paymentType;
    private TouristPackage productPackage;
    

    public Sale() {
    }


    public Sale(Long saleNumber, Date saleDate, Client client, Employee employee, boolean status, PaymentType paymentType, TouristPackage productPackage) {
        this.saleNumber = saleNumber;
        this.saleDate = saleDate;
        this.client = client;
        this.employee = employee;
        this.status = status;
        this.paymentType = paymentType;
        this.productPackage = productPackage;
    }


    public Long getSaleNumber() {
        return this.saleNumber;
    }

    public void setSaleNumber(Long saleNumber) {
        this.saleNumber = saleNumber;
    }

    public Date getSaleDate() {
        return this.saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PaymentType getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public TouristPackage getProductPackage() {
        return this.productPackage;
    }

    public void setProductPackage(TouristPackage productPackage) {
        this.productPackage = productPackage;
    }


}
