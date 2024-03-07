package com.agenciaTurismo.Hackacode.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.agenciaTurismo.Hackacode.dtos.HotelPerNightDto;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.HotelPerNightService;

@Controller
@RequestMapping("/hotelpernight")
public class HotelPerNightController {

    @Autowired
    private HotelPerNightService hotelPerNightService;

    @GetMapping("/register")
    public String register(){
        return "redirect:http://localhost:5173/admin/hotel-per-night";
    }

    @PostMapping("/registry")
    public String registry(@RequestBody HotelPerNightDto hotelPerNightDto, ModelMap model)throws MyException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            
            Date startDateObj = dateFormat.parse(hotelPerNightDto.getStartDate());
            
            try {
                hotelPerNightService.createHotelPerNight(hotelPerNightDto.getName(), hotelPerNightDto.getDescript(), startDateObj, hotelPerNightDto.getPrice(), hotelPerNightDto.getUbication(), hotelPerNightDto.getNumbOfRooms());
                model.put("exito", "El hotel fue cargado correctamente");
            } catch (MyException ex) {
                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/hotel-per-night";
            }
            
            
            
        } catch (ParseException e) {
            e.printStackTrace();

            return "redirect:http://localhost:5173/admin/hotel-per-night";
            
        }
        return "redirect:http://localhost:5173/admin";
    }
    
}
