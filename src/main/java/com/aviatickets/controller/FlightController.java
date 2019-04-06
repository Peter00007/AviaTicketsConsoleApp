package main.java.com.aviatickets.controller;


import main.java.com.aviatickets.model.Flight;
import main.java.com.aviatickets.repository.FlightRepository;

import java.util.Date;
import java.util.List;

public class FlightController {
    FlightRepository flightRepository;

    public FlightController() {
        flightRepository = new FlightRepository();
    }

    public List<Flight> getAllFlight(Date firstDate, Date secondDate, String firstAirport, String secodAirport) {
        return flightRepository.getAllChoiceFlight(firstDate, secondDate, firstAirport, secodAirport);
    }
}
