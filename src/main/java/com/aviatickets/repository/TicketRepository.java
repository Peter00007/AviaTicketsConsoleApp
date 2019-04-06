package main.java.com.aviatickets.repository;


import main.java.com.aviatickets.model.Passenger;
import main.java.com.aviatickets.model.Status;
import main.java.com.aviatickets.model.Ticket;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

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
        int counter = 1;
        Long idTicket = 0L;
        try (BufferedReader readCSV = new BufferedReader(new FileReader(FILE_PATH))) {
            while ((line = readCSV.readLine()) != null) {
                String[] splitBox = line.split(";");
                if (!line.equals("")) {
                    if (Integer.parseInt(splitBox[0]) >= counter) {
                        counter = Integer.parseInt(splitBox[0]) + 1;
                    }
                }
            }
            String strTicket = String.valueOf(counter);
            idTicket = Long.parseLong(strTicket);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return idTicket;
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
        String savePassengerLine = null;
        List<Ticket> list = new ArrayList<>();
        Ticket ticket;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            while ((savePassengerLine = reader.readLine()) != null) {
                String[] getBox = savePassengerLine.split(";");
                String str = "";
                for (int i = 0; i < getBox[4].length(); i++) {
                    if (getBox[4].charAt(i) == ',') {
                        str += '.';
                    } else {
                        str += getBox[4].charAt(i);
                    }
                }
                if (!getBox[0].equalsIgnoreCase(identifier)) {
                    BigDecimal bigDecimal = new BigDecimal(Double.parseDouble(str));
                    bigDecimal.setScale(0, RoundingMode.HALF_UP);
                    Status status = Status.valueOf(getBox[1]);
                    ticket = new Ticket(Long.parseLong(getBox[0]), status,
                            passengerRepository.getByIdPassenger(getBox[2]),
                            flightRepository.getByIdFlight(getBox[3]), bigDecimal);
                    list.add(ticket);
                } else {
                    BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(str));
                    bigDecimal.setScale(0, RoundingMode.HALF_UP);
                    ticket = new Ticket(Long.parseLong(getBox[0]), Status.ONSALE,
                            null, flightRepository.getByIdFlight(getBox[3]), bigDecimal);
                    list.add(ticket);
                    passengerRepository.removePassenger(getBox[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            for (int i = 0; i < list.size(); i++) {
                writer.append(list.get(i).getIdentifier().toString());
                writer.append(";");
                writer.append(list.get(i).getStatus().toString());
                writer.append(";");
                if (list.get(i).getPassenger() != null) {
                    writer.append(list.get(i).getPassenger().getIdentifier());
                } else {
                    writer.append(null);
                }
                writer.append(";");
                writer.append(list.get(i).getFlight().getIdentifier());
                writer.append(";");
                writer.append(list.get(i).getPrice().toString());
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

