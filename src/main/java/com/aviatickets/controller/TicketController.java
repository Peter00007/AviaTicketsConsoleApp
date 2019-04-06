package main.java.com.aviatickets.controller;


import main.java.com.aviatickets.model.Passenger;
import main.java.com.aviatickets.model.Ticket;
import main.java.com.aviatickets.repository.TicketRepository;

import java.math.BigDecimal;

public class TicketController {
    TicketRepository ticketRepository;

    public TicketController() {
        ticketRepository = new TicketRepository();

    }

    public Ticket createTicket(Passenger passenger, String idFlight, BigDecimal price) {
        return ticketRepository.createTicket(passenger, idFlight, price);
    }

    public void returnTicket(String identifier) {
        ticketRepository.withdrawFromReserveTicket(identifier);
    }
}
