package main.java.com.aviatickets.view;


import main.java.com.aviatickets.controller.FlightController;
import main.java.com.aviatickets.model.Flight;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FlightView {
    private final String startMessage = "From what airport will fly?";
    private final String finishAirportMessage = "In which airport will you fly?";
    private final String startDateMessage = "Please choose from which date the flight will take place?\n" +
            "enter the date in the format: dd.MM.yyyy";
    private final String finishDateMessage = "Please enter the last flight date as late as possible\n" +
            "enter the date in the format: dd.MM.yyyy";
    Scanner in;
    FlightController flightController;

    public FlightView() {
        in = new Scanner(System.in);
        flightController = new FlightController();
    }

    public List<Flight> getAllFlight() {
        System.out.println(startMessage);
        String startAirport = in.next();
        System.out.println(finishAirportMessage);
        String finishAirport = in.next();
        System.out.println(startDateMessage);
        String startDate = in.next();
        System.out.println(finishDateMessage);
        String finishDate = in.next();
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date dateStart = formatter.parse(startDate);
            Date dateFinish = formatter.parse(finishDate);
            return flightController.getAllFlight(dateStart, dateFinish, startAirport, finishAirport);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
