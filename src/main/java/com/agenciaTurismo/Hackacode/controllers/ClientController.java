package com.agenciaTurismo.Hackacode.controllers;

import java.text.ParseException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.SimpleDateFormat;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.services.ClientService;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/register")
    public String register() {
        return "client_form.html";
    }

    @PostMapping("/registry")
    public String registry(@RequestParam String name, @RequestParam String surname, @RequestParam String adress,
            @RequestParam(required = false) Integer dni, @RequestParam String birthDate,
            @RequestParam String nationality, @RequestParam String phoneNumber, @RequestParam String email)throws MyException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date birthDate2 = dateFormat.parse(birthDate);

            try {
                clientService.createClient(name, surname, adress, dni, birthDate2, nationality, nationality, email);

            } catch (MyException ex) {

                Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
                return "client_form.html";
            }

        } catch (ParseException e) {
            e.printStackTrace();

            return "client_form.html";

        }

        return "index.html";
    }

}
