package com.agenciaTurismo.Hackacode.controllers;

import java.text.ParseException;
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
import java.text.SimpleDateFormat;
import com.agenciaTurismo.Hackacode.dtos.ClientDto;
import com.agenciaTurismo.Hackacode.entities.Client;
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

    @GetMapping("/get-clients")
    @ResponseBody
    public ResponseEntity<List<Client>> getCars() {
        List <Client> clients=clientService.ListClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/get-client/{id}")
    @ResponseBody
    public ResponseEntity<Client> getClientById(@PathVariable String id) {
        Client client = clientService.GetClient(id);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
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

        return "redirect:http://localhost:5173/admin";
    }

    @PutMapping("/modify")
    public String modify(@RequestBody ClientDto clientDto, ModelMap model) throws MyException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date birthDate2 = dateFormat.parse(clientDto.getBirthDate());
            
            try {
                clientService.modifyClient(clientDto.getClientId(), clientDto.getName(),clientDto.getSurname(),clientDto.getAdress(),clientDto.getDni(),birthDate2,clientDto.getNationality(),clientDto.getPhoneNumber(),clientDto.getEmail());
                model.put("exito", "El cliente fue cargado exitosamente");
            } catch (MyException ex) {
                model.put("error", ex.getMessage());
                return "redirect:http://localhost:5173/admin/client";
            }

        } catch (ParseException ex) {
            model.put("error", "La Fecha no puede ser nula");
            return "redirect:http://localhost:5173/admin/client";

        }

        return "redirect:http://localhost:5173/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@RequestBody ClientDto clientDto, ModelMap model) throws MyException {

        try {
            clientService.deleteClient(clientDto.getClientId());
            model.put("exito", "el cliente fue borrado exitosamente.");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            return "redirect:http://localhost:5173/admin/car-rental";
        }

        return "redirect:http://localhost:5173/admin";
    }

}
