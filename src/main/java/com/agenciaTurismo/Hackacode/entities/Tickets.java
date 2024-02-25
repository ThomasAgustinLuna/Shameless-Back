package com.agenciaTurismo.Hackacode.entities;

import jakarta.persistence.Entity;
import java.util.Date;
import com.agenciaTurismo.Hackacode.enums.TicketType;

@Entity
public class Tickets extends Product {
    private TicketType ticketType;
    private String origin;

    public Tickets() {
    }

    public Tickets(TicketType ticketType, String origin, String productCode, String name, String descript,
            Date startDate, Double price, boolean status) {
        super(productCode, name, descript, startDate, price, status);
        this.ticketType = ticketType;
        this.origin = origin;
    }

    public TicketType getTicketType() {
        return this.ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
