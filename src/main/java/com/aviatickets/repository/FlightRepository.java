package main.java.com.aviatickets.repository;


import main.java.com.aviatickets.model.Flight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightRepository {
    private final String FILE_PATH = "D:\\JavaCourse\\AviaTickets\\src\\main\\resources\\files\\Flight.csv";

    RouteRepository routeRepository;
    AircraftRepository aircraftRepository;

    public FlightRepository() {
        routeRepository = new RouteRepository();
        aircraftRepository = new AircraftRepository();
    }

    public Flight getByIdFlight(String identifier) {
        String line;
        Flight flight;
        try (BufferedReader readCSV = new BufferedReader(new FileReader(FILE_PATH))) {
            while ((line = readCSV.readLine()) != null) {
                String[] getBox = line.split(";");
                if (getBox[0].equalsIgnoreCase(identifier)) {
                    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH.mm");
                    Date flightDate = formatter.parse(getBox[3]);
                    flight = new Flight(getBox[0], routeRepository.getByIdRoute(getBox[1]),
                            aircraftRepository.getByTypeAircraft(getBox[2]), flightDate);
                    return flight;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

