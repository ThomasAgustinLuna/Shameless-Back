package com.agenciaTurismo.Hackacode.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agenciaTurismo.Hackacode.enums.TicketType;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.TicketsService;

@Controller
@RequestMapping("/tickets")
public class TicketsController {

    @Autowired
    private TicketsService ticketsService;
    
    @GetMapping("/register")
    public String register(){
        return "tickets_form.html";
    }

    @PostMapping("/registry")
    public String registry(@RequestParam String name,@RequestParam String descript,@RequestParam String startDate,@RequestParam(required = false) Double price,@RequestParam TicketType ticketType,@RequestParam String origin )throws MyException{

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            
            Date startDateObj = dateFormat.parse(startDate);
            
            try {
                ticketsService.createTickets(name, descript, startDateObj, price, ticketType, origin);
            } catch (MyException ex) {
                Logger.getLogger(CarRentalController.class.getName()).log(Level.SEVERE,null,ex);
                return "tickets_form.html";
            }
            
            
            
        } catch (ParseException e) {
            e.printStackTrace();

            return "tickets_form.html";
            
        }

        return "index.html";
    }
}
