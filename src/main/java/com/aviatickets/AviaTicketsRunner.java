package main.java.com.aviatickets;

import main.java.com.aviatickets.repository.RouteRepository;
import main.java.com.aviatickets.view.ConsoleHelper;

public class AviaTicketsRunner {
    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.startApp();
        RouteRepository routeRepository = new RouteRepository();
        System.out.println(routeRepository.getByIdRoute("2"));
    }
}
/*Airport first = airportRepository.getByNameAirport(firstAirport);
                    Airport second = airportRepository.getByNameAirport(secodAirport);
                    boolean f = routeRepository.getByIdRoute(get[1]).getAirportMap().containsKey(first);
                    boolean r = routeRepository.getByIdRoute(get[1]).getAirportMap().containsKey(second);*/