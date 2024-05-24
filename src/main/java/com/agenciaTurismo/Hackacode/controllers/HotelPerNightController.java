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
import com.agenciaTurismo.Hackacode.dtos.HotelPerNightDto;
import com.agenciaTurismo.Hackacode.entities.HotelPerNight;
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
    @GetMapping("/get-hotels")
    @ResponseBody
    public ResponseEntity<List<HotelPerNight>> getCars() {
        List <HotelPerNight> hotelPerNights=hotelPerNightService.ListHotels();
        return ResponseEntity.ok(hotelPerNights);
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

    @PutMapping("/modify")
    public String modify(@RequestBody HotelPerNightDto hotelPerNightDto, ModelMap model) throws MyException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date startDateObj = dateFormat.parse(hotelPerNightDto.getStartDate());
           
            try {
                hotelPerNightService.modifyHotel(hotelPerNightDto.getProductCode(),hotelPerNightDto.getName(),hotelPerNightDto.getDescript(), startDateObj,hotelPerNightDto.getPrice(),hotelPerNightDto.getUbication(), hotelPerNightDto.getNumbOfRooms());
                model.put("exito", "La excursion fue cargada correctamente");
            } catch (MyException ex) {
                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/hotel-per-night";
            }

        } catch (ParseException ex) {
            model.put("error", "La Fecha no puede ser nula");
            return "redirect:http://localhost:5173/admin/hotel-per-night";

        }

        return "redirect:http://localhost:5173/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@RequestBody HotelPerNightDto hotelPerNightDto, ModelMap model) throws MyException {

        try {
            hotelPerNightService.deleteHotelPerNight(hotelPerNightDto.getProductCode());
            model.put("exito", "El hotel fue borrado exitosamente");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            return "redirect:http://localhost:5173/admin/car-rental";
        }

        return "redirect:http://localhost:5173/admin";
    }
    
}
