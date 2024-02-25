package com.agenciaTurismo.Hackacode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Date;



@Controller
@RequestMapping("/carrental")
public class CarRentalController {

    @GetMapping("/register")
    public String register() {
        return "redirect:http://localhost:5173/index.html";
    }
    
    @PostMapping("/registry")
    public String registry(@RequestParam String name,@RequestParam String descript,@RequestParam Date startDate,@RequestParam Double price,@RequestParam String carType,@RequestParam Date deadLineDate) {
        
        
        return "redirect:http://localhost:5173/index.html";
    }
    
    
}


