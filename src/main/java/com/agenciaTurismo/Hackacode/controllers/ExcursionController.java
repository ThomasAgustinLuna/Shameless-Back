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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.agenciaTurismo.Hackacode.dtos.ExcursionDto;
import com.agenciaTurismo.Hackacode.entities.Excursion;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.ExcursionService;

@Controller
@RequestMapping("/excursion")
public class ExcursionController {
    
    @Autowired
    private ExcursionService excursionService;

    @GetMapping("/register")
    public String register(){
        return "redirect:http://localhost:5173/admin/excursion";
    }
    @GetMapping("/get-excursions")
    @ResponseBody
    public ResponseEntity<List<Excursion>> getCars() {
        List <Excursion> excursions=excursionService.ListExcursions();
        return ResponseEntity.ok(excursions);
    }

    @GetMapping("/get-excursion/{id}")
    @ResponseBody
    public ResponseEntity<Excursion> getExcursionById(@PathVariable String id) {
        Excursion excursion = excursionService.GetExcursion(id);
        if (excursion != null) {
            return ResponseEntity.ok(excursion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/registry")
    public String registry(@RequestBody ExcursionDto excursionDto, ModelMap model)throws MyException{

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            
            Date startDateObj = dateFormat.parse(excursionDto.getStartDate());
            
            try {
                excursionService.createExcursion(excursionDto.getName(),excursionDto.getDescript(), startDateObj, excursionDto.getPrice(), excursionDto.getDestination(), excursionDto.getDuration(), excursionDto.getOrigin());
                model.put("exito", "La excursion fue cargada correctamente");
            } catch (MyException ex) {
                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/excursion";
            }
            
            
            
        } catch (ParseException e) {
            e.printStackTrace();

            return "redirect:http://localhost:5173/admin/excursion";
            
        }



        return "redirect:http://localhost:5173/admin";
    }
    
    @PutMapping("/modify")
    public String modify(@RequestBody ExcursionDto excursionDto, ModelMap model) throws MyException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date startDateObj = dateFormat.parse(excursionDto.getStartDate());
           
            try {
                excursionService.modifyExcursion(excursionDto.getProductCode(),excursionDto.getName(),excursionDto.getDescript(), startDateObj,excursionDto.getPrice(),excursionDto.getDestination(), excursionDto.getDuration(), excursionDto.getOrigin());
                model.put("exito", "La excursion fue cargada correctamente");
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
    public String delete(@RequestBody ExcursionDto excursionDto, ModelMap model) throws MyException {

        try {
            excursionService.deleteExcursion(excursionDto.getProductCode());
            model.put("exito", "La excursion fue borrada exitosamente");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            return "redirect:http://localhost:5173/admin/car-rental";
        }

        return "redirect:http://localhost:5173/admin";
    }
}
