package main.java.com.aviatickets.model;


public class Airport {
    private String identifier;
    private String nameAirport;

    public Airport(String identifier, String nameAirport) {
        this.identifier = identifier;
        this.nameAirport = nameAirport;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getNameAirport() {
        return nameAirport;
    }

    public void setNameAirport(String nameAirport) {
        this.nameAirport = nameAirport;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "identifier='" + identifier + '\'' +
                ", nameAirport='" + nameAirport + '\'' +
                '}';
    }
}
