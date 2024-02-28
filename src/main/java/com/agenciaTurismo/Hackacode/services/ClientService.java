package com.agenciaTurismo.Hackacode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agenciaTurismo.Hackacode.entities.Client;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public void createClient(String name, String surname, String adress, Integer dni, Date birthDate,
            String nationality, String phoneNumber, String email) throws MyException {

        validate(name, surname, adress, dni, birthDate, nationality, phoneNumber, email);
        Client client = new Client();

        client.setName(name);
        client.setSurname(surname);
        client.setAdress(adress);
        client.setDni(dni);
        client.setBirthDate(birthDate);
        client.setNationality(nationality);
        client.setPhoneNumb(phoneNumber);
        client.setEmail(email);
        client.setStatus(true);

        clientRepository.save(client);

    }

    public List<Client> ListClients() {
        List<Client> clients = new ArrayList<>();

        clients = clientRepository.findByStatus(true);

        return clients;
    }

    public void modifyClient(String clientId, String name, String surname, String adress, Integer dni, Date birthDate,
            String nationality, String phoneNumber, String email) throws MyException {

        if (clientId == null) {
            throw new MyException("El id de cliente no puede ser nulo");
        }
        validate(name, surname, adress, dni, birthDate, nationality, phoneNumber, email);
        
        Optional<Client> ans = clientRepository.findById(clientId);

        if (ans.isPresent()) {
            Client client = ans.get();
            if (client.getStatus()) {
                client.setName(name);
                client.setSurname(surname);
                client.setAdress(adress);
                client.setDni(dni);
                client.setBirthDate(birthDate);
                client.setNationality(nationality);
                client.setPhoneNumb(phoneNumber);
                client.setEmail(email);

                clientRepository.save(client);
            } else {
                throw new MyException("No hay registro de ese cliente");
            }

        }

    }

    private void validate(String name, String surname, String adress, Integer dni, Date birthDate, String nationality,
            String phoneNumber, String email) throws MyException {

        if (name == null || name.isEmpty()) {
            throw new MyException("El nombre no puede ser nulo");
        }
        if (surname == null || surname.isEmpty()) {
            throw new MyException("El apellido no puede ser nulo");
        }
        if (adress == null || adress.isEmpty()) {
            throw new MyException("La direccion no puede ser nula");
        }
        if (dni == null) {
            throw new MyException("El dni no puede ser nulo");
        }
        if (birthDate == null) {
            throw new MyException("La fecha de nacimiento no puede ser nula");
        }
        if (nationality == null || nationality.isEmpty()) {
            throw new MyException("La Nacionalidad no puede ser nula");
        }
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new MyException("El numero de telefono no puede ser nulo");
        }
        if (email == null || email.isEmpty()) {
            throw new MyException("El email no puede ser nulo");
        }

    }

}
