package main.java.com.aviatickets.model;


import java.math.BigDecimal;

public class Ticket {
    private Long identifier;
    private Status status;
    private Passenger passenger;
    private Flight flight;
    private BigDecimal price;

    public Ticket(Long identifier, Status status, Passenger passenger, Flight flight, BigDecimal price) {
        this.identifier = identifier;
        this.status = status;
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "identifier=" + identifier +
                ", status=" + status +
                ", passenger=" + passenger +
                ", flight=" + flight +
                ", price=" + price +
                '}';
    }
}
