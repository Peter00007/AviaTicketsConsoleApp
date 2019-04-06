package main.java.com.aviatickets.view;

import main.java.com.aviatickets.model.Flight;

import java.util.Scanner;

public class ConsoleHelper {
    Scanner in;
    FlightView flightView;
    TicketView ticketView;

    private final String startMessage = "Hello customer!";
    private final String choiceNumberMessage = "Enter the number:\n" +
            "1 - if you want to find an available ticket\n" +
            "2 - if you want to buy a ticket\n" +
            "3 - if you want to return the ticket\n" +
            "exit - if want to exit from system.";

    public ConsoleHelper() {
        in = new Scanner(System.in);
        flightView = new FlightView();
        ticketView = new TicketView();
    }

    public void startApp() {
        System.out.println(startMessage);
        String inputChoice;
        do {
            System.out.println(choiceNumberMessage);
            inputChoice = in.next();
            if (inputChoice.equalsIgnoreCase("1")) {
                for (Flight flight : flightView.getAllFlight()) {
                    System.out.println(flight);
                }
            }
            if (inputChoice.equalsIgnoreCase("2")) {
                System.out.println(ticketView.createTicket());

            }
            if (inputChoice.equalsIgnoreCase("3")) {
                ticketView.returnTicket();
            }
        }
        while (!inputChoice.equals("exit"));
    }
}
