package com.transport.delhi.metro.booking.service;

import com.transport.delhi.metro.booking.referencedata.MetroFare;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@AllArgsConstructor
public class FareCalculatorService implements IFareCalculatorService {
    private RouteFinder routeFinder;
    private MetroFare metroFare;

    public Double calculateFare(@NotNull String source, @NotNull String destination) {
        List<String> shortestPathStations = routeFinder.findRoute(source, destination);
        int stationCount = shortestPathStations.size() - 1; // 1 to exclude the source station

        return metroFare.calculateFare(stationCount);

    }
}
