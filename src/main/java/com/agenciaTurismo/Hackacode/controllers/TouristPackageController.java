package com.agenciaTurismo.Hackacode.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.agenciaTurismo.Hackacode.dtos.TouristPackageDto;
import com.agenciaTurismo.Hackacode.entities.TouristPackage;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.TouristPackageService;

@Controller
@RequestMapping("/touristpackage")
public class TouristPackageController {

    @Autowired
    private TouristPackageService touristPackageService;

    @GetMapping("/register")
    public String register() {

        return "redirect:http://localhost:5173/admin/tourist-package";
    }

    @GetMapping("/get-tourist-package")
    @ResponseBody
    public ResponseEntity<List<TouristPackage>> getCars() {
        List<TouristPackage> touristPackages = touristPackageService.ListTouristPackages();
        return ResponseEntity.ok(touristPackages);
    }

    @PostMapping("/registry")
    public String registry(@RequestBody TouristPackageDto touristPackageDto, ModelMap model) throws MyException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> productsCodes = new ArrayList<String>();
        productsCodes.add(touristPackageDto.getCar());
        productsCodes.add(touristPackageDto.getHotel());
        productsCodes.add(touristPackageDto.getEvent());
        productsCodes.add(touristPackageDto.getExcursion());
        productsCodes.add(touristPackageDto.getTicket());

        System.out.println(touristPackageDto.getDescript());
        System.out.println(touristPackageDto.getName());
        System.out.println(touristPackageDto.getCar());
        System.out.println(touristPackageDto.getHotel());
        System.out.println(touristPackageDto.getEvent());
        System.out.println(touristPackageDto.getExcursion());
        System.out.println(touristPackageDto.getTicket());
        System.out.println(touristPackageDto.getStartDate());
        System.out.println(touristPackageDto.getPrice());

       
        
        try {

            Date startDateObj = dateFormat.parse(touristPackageDto.getStartDate());

            try {

                touristPackageService.createTouristPackage(touristPackageDto.getName(), touristPackageDto.getDescript(),
                        startDateObj,productsCodes);
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
