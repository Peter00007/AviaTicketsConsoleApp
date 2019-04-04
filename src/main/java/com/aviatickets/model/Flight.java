package main.java.com.aviatickets.model;


import java.util.Date;

public class Flight {
    private String identifier;
    private Route route;
    private Aircraft aircraft;
    private Date flightDate;

    public Flight(String identifier, Route route, Aircraft aircraft, Date flightDate) {
        this.identifier = identifier;
        this.route = route;
        this.aircraft = aircraft;
        this.flightDate = flightDate;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "identifier='" + identifier + '\'' +
                ", route=" + route +
                ", aircraft=" + aircraft +
                ", flightDate=" + flightDate +
                '}';
    }
}
