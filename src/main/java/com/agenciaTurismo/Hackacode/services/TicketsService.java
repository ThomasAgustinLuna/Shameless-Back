package com.agenciaTurismo.Hackacode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agenciaTurismo.Hackacode.entities.Tickets;
import com.agenciaTurismo.Hackacode.enums.TicketType;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.repositories.TicketsRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketsService {

    @Autowired
    private TicketsRepository ticketsRepository;

    @Transactional
    public void createTickets(String name, String descript, Date startDate, Double price, TicketType ticketType,
            String origin) throws MyException {
        validate(name, descript, startDate, price, ticketType, origin);

        Tickets tickets = new Tickets();
        tickets.setName(name);
        tickets.setDescript(descript);
        tickets.setStartDate(startDate);
        tickets.setPrice(price);
        tickets.setTicketType(ticketType);
        tickets.setOrigin(origin);
        tickets.setStatus(true);

        ticketsRepository.save(tickets);

    }

    public List<Tickets> ListTickets() {
        List<Tickets> tickets = new ArrayList<>();

        tickets = ticketsRepository.findByStatus(true);

        return tickets;
    }

    public void modifyTickets(String productCode, String name, String descript, Date startDate, Double price,
            TicketType ticketType, String origin) throws MyException {
        if (productCode == null) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }
        validate(name, descript, startDate, price, ticketType, origin);
        Optional<Tickets> ans = ticketsRepository.findById(productCode);

        if (ans.isPresent()) {
            Tickets tickets = ans.get();
            if (tickets.isStatus()) {
                tickets.setName(name);
                tickets.setDescript(descript);
                tickets.setStartDate(startDate);
                tickets.setPrice(price);
                tickets.setTicketType(ticketType);
                tickets.setOrigin(origin);

                ticketsRepository.save(tickets);
            } else {
                throw new MyException("No hay registro de ese pasaje");
            }

        }
    }

    public void deleteTickets(String productCode) throws MyException {
        if (productCode == null) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }
        Optional<Tickets> ans = ticketsRepository.findById(productCode);

        if (ans.isPresent()) {
            Tickets tickets= ans.get();
            if (tickets.isStatus()) {
                tickets.setStatus(false);
            }
        }

    }

    private void validate(String name, String descript, Date startDate, Double price, TicketType ticketType,
            String origin) throws MyException {
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
        if (ticketType == null) {
            throw new MyException("El tipo de pasaje no puede ser nulo");
        }
        if (origin == null || origin.isEmpty()) {
            throw new MyException("El origen no puede ser nulo");
        }

    }

}
