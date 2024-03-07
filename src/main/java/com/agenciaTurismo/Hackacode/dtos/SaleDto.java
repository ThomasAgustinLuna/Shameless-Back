package com.agenciaTurismo.Hackacode.dtos;

import com.agenciaTurismo.Hackacode.enums.PaymentType;

public class SaleDto {
    String clientId;
    String employeId;
    PaymentType paymentType;
    String productCode;


    public SaleDto() {
    }


    public SaleDto(String clientId, String employeId, PaymentType paymentType, String productCode) {
        this.clientId = clientId;
        this.employeId = employeId;
        this.paymentType = paymentType;
        this.productCode = productCode;
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

}
