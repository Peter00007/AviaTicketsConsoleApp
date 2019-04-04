package main.java.com.aviatickets.repository;

import main.java.com.aviatickets.model.Aircraft;
import main.java.com.aviatickets.model.CabinType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class AircraftRepository {
    private final String FILE_PATH = "D:\\JavaCourse\\AviaTickets\\src\\main\\resources\\files\\Aircraft.csv";

    public Aircraft getByTypeAircraft(String type) {
        String line;
        Aircraft aircraft;
        try (BufferedReader readCSV = new BufferedReader(new FileReader(FILE_PATH))) {
            while ((line = readCSV.readLine()) != null) {
                String[] getType = line.split(";");
                if (getType[0].equalsIgnoreCase(type)) {
                    String[] getCabinType = getType[1].split(",");
                    String[] getEconomClass = getCabinType[0].split(":");
                    String[] getBusinessClass = getCabinType[1].split(":");
                    Map<CabinType, Integer> map = new LinkedHashMap<>();
                    map.put(CabinType.ECONOM, Integer.parseInt(getEconomClass[1]));
                    map.put(CabinType.BISINESS, Integer.parseInt(getBusinessClass[1]));
                    aircraft = new Aircraft(getType[0], map);
                    return aircraft;
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
