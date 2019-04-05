package main.java.com.aviatickets.view;

import main.java.com.aviatickets.model.Flight;

import java.util.Scanner;

public class ConsoleHelper {
    Scanner in;
    FlightView flightView;

    public ConsoleHelper() {
        in = new Scanner(System.in);
        flightView = new FlightView();
    }

    public void startApp() {
        for (Flight flight: flightView.getAllFlight()) {
            System.out.println(flight);
        }

    }
}
