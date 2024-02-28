package com.agenciaTurismo.Hackacode.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agenciaTurismo.Hackacode.enums.PaymentType;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.SaleService;

@Controller
@RequestMapping("/sale")
public class SaleController {
    // String clientId, String employeeId, PaymentType paymentType, String
    // productCode
    @Autowired
    private SaleService saleService;

    @GetMapping("/register")
    public String register() {
        return "sale_form.html";
    }

    @PostMapping("/registry")
    public String registry(String clientId, String employeId, PaymentType paymentType, String productCode) {

        try {
            saleService.crateSale(clientId, employeId, paymentType, productCode);
        } catch (MyException ex) {
            Logger.getLogger(CarRentalController.class.getName()).log(Level.SEVERE, null, ex);
            return "sale_form.html";
        }
        return "index.html";
    }

}
