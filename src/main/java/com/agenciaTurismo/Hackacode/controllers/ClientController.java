package com.agenciaTurismo.Hackacode.controllers;

import java.text.ParseException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.SimpleDateFormat;
import com.agenciaTurismo.Hackacode.dtos.ClientDto;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/register")
    public String register() {
        return "redirect:http://localhost:5173/admin/client";
    }

    @PostMapping("/registry")
    public String registry(@RequestBody ClientDto clientDto, ModelMap model)throws MyException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date birthDate2 = dateFormat.parse(clientDto.getBirthDate());

            try {
                clientService.createClient(clientDto.getName(), clientDto.getSurname(), clientDto.getAdress(), clientDto.getDni(), birthDate2, clientDto.getNationality(), clientDto.getPhoneNumber(), clientDto.getEmail());
                model.put("exito", "El cliente fue cargado correctamente");
            } catch (MyException ex) {

                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/client";
            }

        } catch (ParseException e) {
            e.printStackTrace();

            return "redirect:http://localhost:5173/admin/client";

        }

        return "redirect:http://localhost:5173/index.html";
    }

}
