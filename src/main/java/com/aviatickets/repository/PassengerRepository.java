package main.java.com.aviatickets.repository;


import main.java.com.aviatickets.model.Passenger;

import java.io.*;

public class PassengerRepository {
    private final String FILE_PATH = "D:\\JavaCourse\\AviaTickets\\src\\main\\resources\\files\\Passenger.csv";

    public Passenger getByIdPassenger(String id) {
        String savePassengerLine;
        Passenger passenger;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            while ((savePassengerLine = reader.readLine()) != null) {
                String[] getBox = savePassengerLine.split(";");
                if (getBox[0].equalsIgnoreCase(id)) {
                    passenger = new Passenger(getBox[0], getBox[1], getBox[2]);
                    return passenger;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Passenger addPassenger(Passenger passenger) {
        try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            StringBuilder sb = new StringBuilder();
            sb.append(passenger.getIdentifier());
            sb.append(";");
            sb.append(passenger.getFirstName());
            sb.append(';');
            sb.append(passenger.getLastName());
            sb.append('\n');
            bufferWriter.write(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passenger;
    }

    public void removePassenger(String identifier) {
        String savePassengerLine = null;
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            //String passengerRecords = passenger.getIdentifier() + ";" + passenger.getFirstName() +";" + passenger.getLastName();
            while ((savePassengerLine = reader.readLine()) != null) {
                String[] getBox = savePassengerLine.split(";");
                if (!getBox[0].equalsIgnoreCase(identifier)) {
                    stringBuffer.append(savePassengerLine).append("\n");
                }
            }
            savePassengerLine = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[] buffer = new char[savePassengerLine.length()];
        savePassengerLine.getChars(0, savePassengerLine.length(), buffer, 0);
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            writer.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
