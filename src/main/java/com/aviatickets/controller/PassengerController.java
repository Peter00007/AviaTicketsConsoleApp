package main.java.com.aviatickets.controller;


import main.java.com.aviatickets.repository.PassengerRepository;

public class PassengerController {
    PassengerRepository passengerRepository;

    public PassengerController() {
        passengerRepository = new PassengerRepository();

    }

    public String getIdPassenger() {
        return passengerRepository.getIdPassenger();
    }
}
