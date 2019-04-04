package main.java.com.aviatickets.model;


import java.util.Date;
import java.util.Map;

public class Route {
    private String description;
    private Map<Airport, Map<String, Date>> airportMap;

    public Route(String description, Map<Airport, Map<String, Date>> airportMap) {
        this.description = description;
        this.airportMap = airportMap;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Airport, Map<String, Date>> getAirportMap() {
        return airportMap;
    }

    public void setAirportMap(Map<Airport, Map<String, Date>> airportMap) {
        this.airportMap = airportMap;
    }

    @Override
    public String toString() {
        return "Route{" +
                "description='" + description + '\'' +
                ", airportMap=" + airportMap +
                '}';
    }
}
