package main.java.com.aviatickets;

import main.java.com.aviatickets.model.Passenger;
import main.java.com.aviatickets.repository.FlightRepository;
import main.java.com.aviatickets.repository.PassengerRepository;
import main.java.com.aviatickets.repository.RouteRepository;
import main.java.com.aviatickets.repository.TicketRepository;

import java.math.BigDecimal;

public class AviaTicketsRunner {
    public static void main(String[] args) {
        /*AirportRepository airportRepository = new AirportRepository();
        System.out.println(airportRepository.getByNameAirport(""));*/

        RouteRepository routeRepository = new RouteRepository();
        System.out.println(routeRepository.getByIdRoute("2"));

        /*AircraftRepository aircraftRepository = new AircraftRepository();
        System.out.println(aircraftRepository.getByTypeAircraft("An"));*/

        FlightRepository flightRepository = new FlightRepository();
        System.out.println(flightRepository.getByIdFlight("2"));

        PassengerRepository passengerRepository = new PassengerRepository();
        /*passengerRepository.addPassenger(new Passenger("A","a"));
        passengerRepository.addPassenger(new Passenger("D","d"));
        passengerRepository.addPassenger(new Passenger("s","d"));*/
        passengerRepository.addPassenger(new Passenger("1","Peter", "Fediuk"));

        BigDecimal bigDecimal = BigDecimal.valueOf(10.1);
        Passenger passenger = new Passenger("2", "s","s");
        TicketRepository ticketRepository = new TicketRepository();
        ticketRepository.createTicket(passenger, "1", bigDecimal);

    }
}
