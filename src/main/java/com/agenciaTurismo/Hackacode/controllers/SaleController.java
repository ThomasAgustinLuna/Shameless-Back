package com.agenciaTurismo.Hackacode.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        List<Sale> sales = saleService.ListSales();
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/get-sale/{id}")
    @ResponseBody
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        Sale sale = saleService.GetSale(id);
        if (sale != null) {
            return ResponseEntity.ok(sale);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/registry")
    public String registry(@RequestBody SaleDto saleDto, ModelMap model) {

        try {
            saleService.crateSale(saleDto.getClientId(), saleDto.getEmployeId(), saleDto.getPaymentType(),
                    saleDto.getProductCode());
            model.put("exito", "La venta fue cargada correctamente");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            return "redirect:http://localhost:5173/admin/sale";
        }
        return "redirect:http://localhost:5173/admin";
    }

    @PutMapping("/modify")
    public String modify(@RequestBody SaleDto saleDto, ModelMap model) throws MyException {

        try {
            saleService.modifySale(saleDto.getSaleNumber(), saleDto.getClientId(), saleDto.getEmployeId(),
                    saleDto.getPaymentType(), saleDto.getProductCode());
            model.put("exito", "La excursion fue cargada correctamente");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            return "redirect:http://localhost:5173/admin/tickets";
        }

        return "redirect:http://localhost:5173/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@RequestBody SaleDto saleDto, ModelMap model) throws MyException {

        try {
            saleService.deleteSale(saleDto.getSaleNumber());
            model.put("exito", "La renta fue borrada exitosamente");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            return "redirect:http://localhost:5173/admin/car-rental";
        }

        return "redirect:http://localhost:5173/admin";
    }

}
