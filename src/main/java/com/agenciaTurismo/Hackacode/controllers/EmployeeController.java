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
import com.agenciaTurismo.Hackacode.enums.PositionType;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService emEmployeeService;

    @GetMapping("/register")
    public String register() {

        return "employee_form.html";
    }

    @PostMapping("/registry")
    public String registry(@RequestParam String name, @RequestParam String surname, @RequestParam String adress,
            @RequestParam(required = false) Integer dni, @RequestParam String birthDate,
            @RequestParam String nationality, @RequestParam String phoneNumber, @RequestParam String email,
            @RequestParam PositionType position, @RequestParam(required = false) Double salary)throws MyException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date birthDate2 = dateFormat.parse(birthDate);

            try {
                emEmployeeService.createEmployee(name, surname, adress, dni, birthDate2, nationality, phoneNumber,
                        email, position, salary);

            } catch (MyException ex) {

                Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
                return "employee_form.html";
            }

        } catch (ParseException e) {
            e.printStackTrace();

            return "employee_form.html";

        }

        return "index.html";
    }

}
