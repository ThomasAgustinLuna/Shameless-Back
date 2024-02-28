package com.agenciaTurismo.Hackacode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.CarRentalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Date;
import java.util.logging.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

@Controller
@RequestMapping("/carrental")
public class CarRentalController {
    @Autowired
    private CarRentalService carRentalService;
    //redirect:http://localhost:5173/index.html
    @GetMapping("/register")
    public String register() {
        return "car_rental_form.html";
    }
    
    @PostMapping("/registry")
    public String registry(@RequestParam String name,@RequestParam String descript,@RequestParam String startDate,@RequestParam(required = false) Double price,@RequestParam String carType ,@RequestParam String deadlineDate) throws MyException{
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            
            Date startDateObj = dateFormat.parse(startDate);
            Date deadlineDateObj = dateFormat.parse(deadlineDate);
            try {
                carRentalService.createCarRental(name, descript, startDateObj, price, carType, deadlineDateObj);
            } catch (MyException ex) {
                Logger.getLogger(CarRentalController.class.getName()).log(Level.SEVERE,null,ex);
                return "car_rental_form.html";
            }
            
            
            
        } catch (ParseException e) {
            e.printStackTrace();

            return "car_rental_form.html";
            
        }

        return "index.html";
    }


    
    
}


