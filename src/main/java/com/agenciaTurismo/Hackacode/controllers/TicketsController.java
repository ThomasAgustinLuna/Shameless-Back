package com.agenciaTurismo.Hackacode.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.agenciaTurismo.Hackacode.dtos.TicketsDto;
import com.agenciaTurismo.Hackacode.entities.Tickets;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.TicketsService;

@Controller
@RequestMapping("/tickets")
public class TicketsController {

    @Autowired
    private TicketsService ticketsService;
    
    @GetMapping("/register")
    public String register(){
        return "redirect:http://localhost:5173/admin/tickets";
    }

    @GetMapping("/get-tickets")
    @ResponseBody
    public ResponseEntity<List<Tickets>> getCars() {
        List <Tickets> tickets=ticketsService.ListTickets();
        return ResponseEntity.ok(tickets);
    }

    @PostMapping("/registry")
    public String registry(@RequestBody TicketsDto ticketsDto,ModelMap model)throws MyException{

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            
            Date startDateObj = dateFormat.parse(ticketsDto.getStartDate());
            
            try {
                ticketsService.createTickets(ticketsDto.getName(), ticketsDto.getDescript(), startDateObj, ticketsDto.getPrice(), ticketsDto.getTicketType(), ticketsDto.getOrigin(), ticketsDto.getDestination());
                model.put("exito", "El pasaje fue cargado correctamente");
            } catch (MyException ex) {
                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/tickets";
            }
            
            
            
        } catch (ParseException e) {
            e.printStackTrace();

            return "redirect:http://localhost:5173/admin/tickets";
            
        }

        return "redirect:http://localhost:5173/admin";
    }
}
