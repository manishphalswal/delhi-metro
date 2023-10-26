package com.transport.delhi.metro.booking.referencedata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class MetroFare {

    private final List<FareRange> fareRanges;

    public MetroFare() {
        fareRanges = new ArrayList<>();
    }

    @PostConstruct
    public void initFare() {
        if (fareRanges.isEmpty()) {
            fareRanges.add(new FareRange(1, 1, 10.0));
            fareRanges.add(new FareRange(2, 2, 20.0));
            fareRanges.add(new FareRange(3, 5, 25.0));
            fareRanges.add(new FareRange(6, 10, 30.0));
            fareRanges.add(new FareRange(11, 15, 35.0));
            fareRanges.add(new FareRange(15, 20, 40.0));
            fareRanges.add(new FareRange(21, 25, 45.0));
            fareRanges.add(new FareRange(26, 30, 50.0));
            fareRanges.add(new FareRange(31, Integer.MAX_VALUE, 60.0));
        }
    }

    @AllArgsConstructor
    private static class FareRange {
        int lowerBound;
        int upperBound;
        Double fare;
    }

    public Double calculateFare(int stationCount) {
        return fareRanges.stream()
                .filter(range -> range.lowerBound <= stationCount && range.upperBound >= stationCount)
                .map(fareRange -> fareRange.fare)
                .findFirst()
                .orElse(0.0);
    }
}
