package main.java.com.aviatickets.repository;


import main.java.com.aviatickets.model.Airport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AirportRepository {
    private final String FILE_PATH = "D:\\JavaCourse\\AviaTickets\\src\\main\\resources\\files\\Airport.csv";

    public Airport getByIdAirport(String identifier) {
        String line;
        Airport airport;
        try (BufferedReader readCSV = new BufferedReader(new FileReader(FILE_PATH))) {
            while ((line = readCSV.readLine()) != null) {
                String[] getId = line.split(";");
                if (getId[0].equals(identifier)) {
                    airport = new Airport(getId[0], getId[1]);
                    return airport;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Airport getByNameAirport(String nameAirport) {
        String line;
        Airport airport;
        try (BufferedReader readCSV = new BufferedReader(
                new FileReader(FILE_PATH))) {
            while ((line = readCSV.readLine()) != null) {
                String[] getId = line.split(";");
                if (getId[1].equalsIgnoreCase(nameAirport)) {
                    airport = new Airport(getId[0], getId[1]);
                    return airport;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
