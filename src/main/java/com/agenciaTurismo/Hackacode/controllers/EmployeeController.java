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
import com.agenciaTurismo.Hackacode.dtos.EmployeeDto;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService emEmployeeService;

    @GetMapping("/register")
    public String register() {

        return "redirect:http://localhost:5173/admin/employee";
    }

    @PostMapping("/registry")
    public String registry(@RequestBody EmployeeDto employeeDto, ModelMap model) throws MyException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date birthDate2 = dateFormat.parse(employeeDto.getBirthDate());

            try {
                emEmployeeService.createEmployee(employeeDto.getName(), employeeDto.getSurname(),
                        employeeDto.getAdress(), employeeDto.getDni(), birthDate2, employeeDto.getNationality(),
                        employeeDto.getEmail(),
                        employeeDto.getPhoneNumber(), employeeDto.getPosition(), employeeDto.getSalary());
                model.put("exito", "El empleado fue cargado correctamente");

            } catch (MyException ex) {

                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/employee";
            }

        } catch (ParseException e) {
            e.printStackTrace();

            return "redirect:http://localhost:5173/admin/employee";

        }

        return "redirect:http://localhost:5173/index.html";
    }

}
