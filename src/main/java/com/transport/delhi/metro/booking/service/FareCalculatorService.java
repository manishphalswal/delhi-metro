package com.transport.delhi.metro.booking.service;

import com.transport.delhi.metro.booking.referencedata.MetroFare;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FareCalculatorService implements IFareCalculatorService {
    private IRouteService routeService;
    private MetroFare metroFare;

    public Double calculateFare(String source, String destination) {
        List<String> shortestPathStations = routeService.findRoute(source, destination);
        int stationCount = shortestPathStations.size() - 1; // 1 to exclude the source station

        return metroFare.calculateFare(stationCount);

    }
}
