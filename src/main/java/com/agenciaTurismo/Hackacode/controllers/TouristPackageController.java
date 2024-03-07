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
import com.agenciaTurismo.Hackacode.dtos.TouristPackageDto;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.TouristPackageService;

@Controller
@RequestMapping("/touristpackage")
public class TouristPackageController {

    @Autowired
    private TouristPackageService touristPackageService;

    @GetMapping("/register")
    public String register(){
 
        return "redirect:http://localhost:5173/admin/tourist-package";
    }

    @PostMapping("/registry")
    public String registry(@RequestBody TouristPackageDto touristPackageDto, ModelMap model)throws MyException{

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            
            Date startDateObj = dateFormat.parse(touristPackageDto.getStartDate());
            
            try {
                touristPackageService.createTouristPackage(touristPackageDto.getName(), touristPackageDto.getDescript(), startDateObj,touristPackageDto.getPrice(), null);
                model.put("exito", "El paquete fue cargado correctamente");
            } catch (MyException ex) {
                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/tourist-package";
            }
            
            
            
        } catch (ParseException e) {
            e.printStackTrace();

            return "redirect:http://localhost:5173/admin/tourist-package";
            
        }
        return "redirect:http://localhost:5173/admin";

    }
    
}
