package main.java.com.aviatickets.view;


import main.java.com.aviatickets.controller.TicketController;
import main.java.com.aviatickets.model.Ticket;

import java.math.BigDecimal;
import java.util.Scanner;

public class TicketView {
    private final String inputFirstNameMessage = "Input  passenger first name, please";
    private final String inputLastNameMessage = "Input passenger last name, please";
    private final String inputIdFlight = "Input ID Flight, please";
    private final String inputTicketPrice = "Input ticket price";
    private final String inputIDReturnTicket = "Input ID return Ticket, please";

    Scanner in;
    TicketController ticketController;
    PassengerView passengerView;

    public TicketView() {
        in = new Scanner(System.in);
        ticketController = new TicketController();
        passengerView = new PassengerView();
    }

    public Ticket createTicket() {
        System.out.println(inputFirstNameMessage);
        String inputFirstName = in.next();
        System.out.println(inputLastNameMessage);
        String inputLastName = in.next();
        System.out.println(inputIdFlight);
        String inputIDFlight = in.next();
        System.out.println(inputTicketPrice);
        String inputTicketPrice = in.next();
        BigDecimal ticketPrice = BigDecimal.valueOf(Double.parseDouble(inputTicketPrice));
        Ticket ticket = ticketController.createTicket(passengerView.createPassenger(inputFirstName, inputLastName),
                inputIDFlight, ticketPrice);
        return ticket;
    }

    public void returnTicket() {
        System.out.println(inputIDReturnTicket);
        String idReturnTicket = in.next();
        ticketController.returnTicket(idReturnTicket);
    }
}
