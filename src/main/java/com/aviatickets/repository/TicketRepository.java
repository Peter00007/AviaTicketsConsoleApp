package main.java.com.aviatickets.repository;


import main.java.com.aviatickets.model.Passenger;
import main.java.com.aviatickets.model.Status;
import main.java.com.aviatickets.model.Ticket;

import java.io.*;
import java.math.BigDecimal;

public class TicketRepository {
    private final String FILE_PATH = "D:\\JavaCourse\\AviaTickets\\src\\main\\resources\\files\\Ticket.csv";

    PassengerRepository passengerRepository;
    FlightRepository flightRepository;

    public TicketRepository() {
        passengerRepository = new PassengerRepository();
        flightRepository = new FlightRepository();
    }

    public Long getIdTicket() {
        String line;
        Long counter = 0L;
        try (BufferedReader readCSV = new BufferedReader(new FileReader(FILE_PATH))) {
            while ((line = readCSV.readLine()) != null) {
                String[] splitBox = line.split(";");
                if (Long.parseLong(splitBox[0]) > counter) {
                    counter = Long.parseLong(splitBox[0]) + 1;
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return counter;
    }

    public Ticket createTicket(Passenger passenger, String idFlight, BigDecimal price) {
        Long id = getIdTicket();
        Ticket ticket = new Ticket(id, Status.RESERVED, passengerRepository.addPassenger(passenger),
                flightRepository.getByIdFlight(idFlight), price);
        try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            StringBuilder sb = new StringBuilder();
            sb.append(ticket.getIdentifier());
            sb.append(";");
            sb.append(ticket.getStatus());
            sb.append(';');
            sb.append(ticket.getPassenger().getIdentifier());
            sb.append(';');
            sb.append(ticket.getFlight().getIdentifier());
            sb.append(';');
            sb.append(ticket.getPrice());
            sb.append('\n');
            bufferWriter.write(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ticket;
    }

    public void withdrawFromReserveTicket(String identifier) {

    }
}

