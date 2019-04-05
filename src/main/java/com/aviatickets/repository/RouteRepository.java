package main.java.com.aviatickets.repository;

import main.java.com.aviatickets.model.Airport;
import main.java.com.aviatickets.model.Route;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RouteRepository {
    private final String FILE_PATH = "D:\\JavaCourse\\AviaTickets\\src\\main\\resources\\files\\Route.csv";
    private final String DEPARTURE = "DEPARTURE";
    private final String ARRIVAL = "ARRIVAL";

    AirportRepository airportRepository;

    public RouteRepository() {
        airportRepository = new AirportRepository();
    }

    public Route getByIdRoute(String description) {
        String line;
        Route route;
        try (BufferedReader readCSV = new BufferedReader(new FileReader(FILE_PATH))) {
            while ((line = readCSV.readLine()) != null) {
                String[] getId = line.split(";");
                if (getId[0].equals(description)) {
                    String[] get = getId[1].split(",");
                    String[] splitFirstBox = get[0].split(":");
                    String[] firstBox = splitFirstBox[1].split("-");
                    String[] splitSecondBox = get[1].split("-");
                    String[] splitThirdBox = get[2].split(":");
                    String[] thirdBox = splitThirdBox[1].split("-");
                    String[] fourthBox = get[3].split("-");
                    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH.mm");
                    Date firstDateDeparture = formatter.parse(firstBox[1]);
                    Date firstDateArrival = formatter.parse(splitSecondBox[1]);
                    Date secondDateDeparture = formatter.parse(thirdBox[1]);
                    Date secondDateArrival = formatter.parse(fourthBox[1]);
                    Map<String, Date> firstStringDateMap = new LinkedHashMap<>();
                    firstStringDateMap.put(DEPARTURE, firstDateDeparture);
                    firstStringDateMap.put(ARRIVAL, firstDateArrival);
                    Map<Airport, Map<String, Date>> airportMapMap = new LinkedHashMap<>();
                    airportMapMap.put(airportRepository.getByNameAirport(splitFirstBox[0]), firstStringDateMap);
                    Map<String, Date> secondStringDateMap = new LinkedHashMap<>();
                    secondStringDateMap.put(DEPARTURE, secondDateDeparture);
                    secondStringDateMap.put(ARRIVAL, secondDateArrival);
                    airportMapMap.put(airportRepository.getByNameAirport(splitThirdBox[0]), secondStringDateMap);
                    route = new Route(getId[0], airportMapMap);
                    return route;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getAllChoiceRouteId(String startAirport, String finishAirport) {
        String line;
        List<String> list = new ArrayList<>();
        try (BufferedReader readCSV = new BufferedReader(new FileReader(FILE_PATH))) {
            while ((line = readCSV.readLine()) != null) {
                String[] getId = line.split(";");
                String[] getBox = getId[1].split(",");
                String[] startBox = getBox[0].split(":");
                String[] finishBox = getBox[2].split(":");
                if (startBox[0].equalsIgnoreCase(startAirport) && finishBox[0].equalsIgnoreCase(finishAirport)) {
                    list.add(getId[0]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
