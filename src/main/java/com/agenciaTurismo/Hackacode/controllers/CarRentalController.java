package com.agenciaTurismo.Hackacode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.agenciaTurismo.Hackacode.dtos.CarRentalDto;
import com.agenciaTurismo.Hackacode.entities.CarRental;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.CarRentalService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/carrental")
public class CarRentalController {
    @Autowired
    private CarRentalService carRentalService;

    @GetMapping("/register")
    public String register() {

        return "redirect:http://localhost:5173/admin/car-rental";
    }

    @GetMapping("/get-cars")
    @ResponseBody
    public ResponseEntity<List<CarRental>> getCars() {
        List<CarRental> cars = carRentalService.ListCarRentals();
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/registry")
    public String registry(@RequestBody CarRentalDto carRentalDto, ModelMap model) throws MyException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date startDateObj = dateFormat.parse(carRentalDto.getStartDate());
            Date deadlineDateObj = dateFormat.parse(carRentalDto.getDeadlineDate());
            try {
                carRentalService.createCarRental(carRentalDto.getName(), carRentalDto.getDescript(), startDateObj,
                        carRentalDto.getPrice(), carRentalDto.getCarType(), deadlineDateObj);
                model.put("exito", "La renta del auto fue cargada correctamente");
            } catch (MyException ex) {
                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/car-rental";
            }

        } catch (ParseException ex) {
            model.put("error", "La Fecha no puede ser nula");
            return "redirect:http://localhost:5173/admin/car-rental";

        }

        return "redirect:http://localhost:5173/admin";
    }

    @PutMapping("/modify")
    public String modify(@RequestBody CarRentalDto carRentalDto, ModelMap model) throws MyException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date startDateObj = dateFormat.parse(carRentalDto.getStartDate());
            Date deadlineDateObj = dateFormat.parse(carRentalDto.getDeadlineDate());
            try {
                carRentalService.modifyCarRental(carRentalDto.getProductCode(), carRentalDto.getName(),
                        carRentalDto.getDescript(), startDateObj, carRentalDto.getPrice(), carRentalDto.getCarType(),
                        deadlineDateObj);
                model.put("exito", "La renta del auto fue cargada correctamente");
            } catch (MyException ex) {
                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/car-rental";
            }

        } catch (ParseException ex) {
            model.put("error", "La Fecha no puede ser nula");
            return "redirect:http://localhost:5173/admin/car-rental";

        }

        return "redirect:http://localhost:5173/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@RequestBody CarRentalDto carRentalDto, ModelMap model) throws MyException {

        try {
            carRentalService.deleteCarRental(carRentalDto.getProductCode());
            model.put("exito", "La renta fue borrada exitosamente");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            return "redirect:http://localhost:5173/admin/car-rental";
        }

        return "redirect:http://localhost:5173/admin";
    }

}
