package main.java.com.aviatickets.view;


import main.java.com.aviatickets.controller.PassengerController;
import main.java.com.aviatickets.model.Passenger;

public class PassengerView {
    PassengerController passengerController;

    public PassengerView() {
        passengerController = new PassengerController();
    }

    public Passenger createPassenger(String firstName, String lastName) {
        String idPassenger = passengerController.getIdPassenger();
        return new Passenger(idPassenger, firstName, lastName);
    }
}
