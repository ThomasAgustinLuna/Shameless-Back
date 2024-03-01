package com.agenciaTurismo.Hackacode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.agenciaTurismo.Hackacode.entities.EventTickets;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.repositories.EventTicketsRepository;
import jakarta.transaction.Transactional;

@Service
public class EventTicketsService {

    @Autowired
    private EventTicketsRepository eventTicketsRepository;

    @Transactional
    public void createEventTickets(String name, String descript, Date startDate, Double price, String ubication,
            Double duration) throws MyException {
        validate(name, descript, startDate, price, ubication, duration);

        EventTickets eventTickets = new EventTickets();

        eventTickets.setName(name);
        eventTickets.setDescript(descript);
        eventTickets.setPrice(price);
        eventTickets.setUbication(ubication);
        eventTickets.setStartDate(startDate);
        eventTickets.setDuration(duration);
        eventTickets.setStatus(true);

        eventTicketsRepository.save(eventTickets);

    }

    public List<EventTickets> ListEventTickets() {
        List<EventTickets> eventTickets = new ArrayList<>();

        eventTickets = eventTicketsRepository.findByStatus(true);

        return eventTickets;
    }

    public void modifyEventTickets(String productCode, String name, String descript, Date startDate, Double price,
            String ubication, Double duration) throws MyException {

        if (productCode == null) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }
        validate(name, descript, startDate, price, ubication, duration);
        Optional<EventTickets> ans = eventTicketsRepository.findById(productCode);

        if (ans.isPresent()) {
            EventTickets eventTickets = ans.get();
            if (eventTickets.isStatus()) {
                eventTickets.setName(name);
                eventTickets.setDescript(descript);
                eventTickets.setStartDate(startDate);
                eventTickets.setPrice(price);
                eventTickets.setUbication(ubication);
                eventTickets.setDuration(duration);

                eventTicketsRepository.save(eventTickets);
            } else {
                throw new MyException("No hay registro de ese evento");
            }

        }

    } 

    public void deleteEventTickets(String productCode) throws MyException {
        if (productCode == null) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }
        Optional<EventTickets> ans = eventTicketsRepository.findById(productCode);

        if (ans.isPresent()) {
            EventTickets eventTickets= ans.get();
            if (eventTickets.isStatus()) {
                eventTickets.setStatus(false);
            }
        }

    }

    private void validate(String name, String descript, Date startDate, Double price, String ubication, Double duration)
            throws MyException {
        if (name == null || name.isEmpty()) {
            throw new MyException("El nombre no puede ser nulo");
        }
        if (descript == null || descript.isEmpty()) {
            throw new MyException("La descripcion no puede ser nula");
        }
        if (startDate == null) {
            throw new MyException("La fecha inicial no puede ser nula");
        }
        if (price == null || price.isNaN()) {
            throw new MyException("El precio no puede ser nulo");
        }
        if (ubication == null || ubication.isEmpty()) {
            throw new MyException("El tipo de ubicacion no puede ser nula");
        }
        if (duration == null || duration.isNaN()) {
            throw new MyException("La duracion no puede ser nula");
        }
    }

}
