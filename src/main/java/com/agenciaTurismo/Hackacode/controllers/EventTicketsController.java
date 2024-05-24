package com.agenciaTurismo.Hackacode.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.agenciaTurismo.Hackacode.dtos.EventTicketsDto;
import com.agenciaTurismo.Hackacode.entities.EventTickets;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.EventTicketsService;

@Controller
@RequestMapping("/eventtickets")
public class EventTicketsController {

    @Autowired
    private EventTicketsService eventTicketsService;

    @GetMapping("/register")
    public String register(){
        return "redirect:http://localhost:5173/admin/event-tickets";
    }

    @GetMapping("/get-event-tickets")
    @ResponseBody
    public ResponseEntity<List<EventTickets>> getCars() {
        List <EventTickets> eventTickets=eventTicketsService.ListEventTickets();
        return ResponseEntity.ok(eventTickets);
    }

    @PostMapping("/registry")
    public String registry (@RequestBody EventTicketsDto eventTicketsDto, ModelMap model)throws MyException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            
            Date startDateObj = dateFormat.parse(eventTicketsDto.getStartDate());
            
            try {
                eventTicketsService.createEventTickets(eventTicketsDto.getName(), eventTicketsDto.getDescript(), startDateObj, eventTicketsDto.getPrice(), eventTicketsDto.getUbication(), eventTicketsDto.getDuration());
                model.put("exito", "El evento fue cargado correctamente");
            } catch (MyException ex) {
                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/event-tickets";
            }
            
            
            
        } catch (ParseException e) {
            e.printStackTrace();

            return "redirect:http://localhost:5173/admin/event-tickets";
            
        }
        
        return "redirect:http://localhost:5173/admin";
    }
    
    @PutMapping("/modify")
    public String modify(@RequestBody EventTicketsDto eventTicketsDto, ModelMap model) throws MyException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date startDateObj = dateFormat.parse(eventTicketsDto.getStartDate());
            
            try {
                eventTicketsService.modifyEventTickets(eventTicketsDto.getProductCode(),eventTicketsDto.getName(),eventTicketsDto.getDescript(), startDateObj,eventTicketsDto.getPrice(),eventTicketsDto.getUbication(),eventTicketsDto.getDuration());
                model.put("exito", "El evento fue cargado correctamente");
            } catch (MyException ex) {
                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/event-tickets";
            }

        } catch (ParseException ex) {
            model.put("error", "La Fecha no puede ser nula");
            return "redirect:http://localhost:5173/admin/event-tickets";

        }

        return "redirect:http://localhost:5173/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@RequestBody EventTicketsDto eventTicketsDto, ModelMap model) throws MyException {

        try {
            eventTicketsService.deleteEventTickets(eventTicketsDto.getProductCode());
            model.put("exito", "La entrada de evento fue borrada exitosamente");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            return "redirect:http://localhost:5173/admin/car-rental";
        }

        return "redirect:http://localhost:5173/admin";
    }

}
