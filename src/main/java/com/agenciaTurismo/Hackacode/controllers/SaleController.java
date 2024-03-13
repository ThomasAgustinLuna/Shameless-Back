package com.agenciaTurismo.Hackacode.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.agenciaTurismo.Hackacode.dtos.SaleDto;
import com.agenciaTurismo.Hackacode.entities.Sale;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.SaleService;

@Controller
@RequestMapping("/sale")
public class SaleController {
 
    @Autowired
    private SaleService saleService;

    @GetMapping("/register")
    public String register() {
        return "redirect:http://localhost:5173/admin/sale";
    }
    @GetMapping("/get-sales")
    @ResponseBody
    public ResponseEntity<List<Sale>> getCars() {
        List <Sale> sales=saleService.ListSales();
        return ResponseEntity.ok(sales);
    }

    @PostMapping("/registry")
    public String registry(@RequestBody SaleDto saleDto, ModelMap model) {

        try {
            saleService.crateSale(saleDto.getClientId(), saleDto.getEmployeId(), saleDto.getPaymentType(), saleDto.getProductCode());
            model.put("exito", "La venta fue cargada correctamente");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            return "redirect:http://localhost:5173/admin/sale";
        }
        return "redirect:http://localhost:5173/admin";
    }

}
