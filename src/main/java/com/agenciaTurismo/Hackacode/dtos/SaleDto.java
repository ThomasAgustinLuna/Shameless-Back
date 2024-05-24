package com.agenciaTurismo.Hackacode.dtos;


import com.agenciaTurismo.Hackacode.enums.PaymentType;

public class SaleDto {
    private Long saleNumber;
    private String clientId;
    private String employeId;
    private PaymentType paymentType;
    private String productCode;
    private String saleDate;


    public SaleDto() {
    }


    public SaleDto(Long saleNumber, String clientId, String employeId, PaymentType paymentType, String productCode, String saleDate) {
        this.saleNumber = saleNumber;
        this.clientId = clientId;
        this.employeId = employeId;
        this.paymentType = paymentType;
        this.productCode = productCode;
        this.saleDate = saleDate;
    }


    public Long getSaleNumber() {
        return this.saleNumber;
    }

    public void setSaleNumber(Long saleNumber) {
        this.saleNumber = saleNumber;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getEmployeId() {
        return this.employeId;
    }

    public void setEmployeId(String employeId) {
        this.employeId = employeId;
    }

    public PaymentType getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getSaleDate() {
        return this.saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }


    
    
}
