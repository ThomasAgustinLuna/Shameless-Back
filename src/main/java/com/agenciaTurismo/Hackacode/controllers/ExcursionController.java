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
import com.agenciaTurismo.Hackacode.dtos.ExcursionDto;
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

    @PostMapping("/registry")
    public String registry(@RequestBody ExcursionDto excursionDto, ModelMap model)throws MyException{

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            
            Date startDateObj = dateFormat.parse(excursionDto.getStartDate());
            
            try {
                excursionService.createExcursion(excursionDto.getName(),excursionDto.getDescript(), startDateObj, excursionDto.getPrice(), excursionDto.getDestination(), excursionDto.getDuration());
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
    
}
