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
import com.agenciaTurismo.Hackacode.dtos.EmployeeDto;
import com.agenciaTurismo.Hackacode.entities.Employee;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/register")
    public String register() {

        return "redirect:http://localhost:5173/admin/employee";
    }

    @GetMapping("/get-employees")
    @ResponseBody
    public ResponseEntity<List<Employee>> getCars() {
        List <Employee> employees=employeeService.ListEmployees();
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/registry")
    public String registry(@RequestBody EmployeeDto employeeDto, ModelMap model) throws MyException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date birthDate2 = dateFormat.parse(employeeDto.getBirthDate());

            try {
                employeeService.createEmployee(employeeDto.getName(), employeeDto.getSurname(),employeeDto.getAdress(), employeeDto.getDni(), birthDate2, employeeDto.getNationality(),employeeDto.getPhoneNumber(),employeeDto.getEmail(), employeeDto.getPosition(), employeeDto.getSalary());
                model.put("exito", "El empleado fue cargado correctamente");

            } catch (MyException ex) {

                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/employee";
            }

        } catch (ParseException e) {
            e.printStackTrace();

            return "redirect:http://localhost:5173/admin/employee";

        }

        return "redirect:http://localhost:5173/admin";
    }

    @PutMapping("/modify")
    public String modify(@RequestBody EmployeeDto employeeDto, ModelMap model) throws MyException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date birthDate2 = dateFormat.parse(employeeDto.getBirthDate());
            
            try {
                employeeService.modifyEmployee(employeeDto.getEmployeeId(), employeeDto.getName(),employeeDto.getSurname(),employeeDto.getAdress(),employeeDto.getDni(),birthDate2,employeeDto.getNationality(),employeeDto.getPhoneNumber(),employeeDto.getEmail(),employeeDto.getPosition(), employeeDto.getSalary());
                model.put("exito", "El empleado fue cargado exitosamente");
            } catch (MyException ex) {
                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/employee";
            }

        } catch (ParseException ex) {
            model.put("error", "La Fecha no puede ser nula");
            return "redirect:http://localhost:5173/admin/employee";

        }

        return "redirect:http://localhost:5173/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@RequestBody EmployeeDto employeeDto, ModelMap model) throws MyException {

        try {
            employeeService.deleteEmployee(employeeDto.getEmployeeId());
            model.put("exito", "El empleado fue borrado exitosamente");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            return "redirect:http://localhost:5173/admin/car-rental";
        }

        return "redirect:http://localhost:5173/admin";
    }

}
