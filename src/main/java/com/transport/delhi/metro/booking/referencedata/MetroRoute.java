package com.transport.delhi.metro.booking.referencedata;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@Getter
public class MetroRoute {
    private final Map<String, List<String>> stationAdjacencyList;

    public MetroRoute() {
        stationAdjacencyList = new HashMap<>();
    }

    public void addStation(String stationName, List<String> connectedStations) {
        stationAdjacencyList.put(stationName, new ArrayList<>(connectedStations));
    }


    @PostConstruct
    public void init() {
        if (stationAdjacencyList.isEmpty()) {
            // Add metro stations and their connections
            this.addStation("A", Arrays.asList("B", "C"));
            this.addStation("B", Arrays.asList("A", "D", "E"));
            this.addStation("C", Arrays.asList("A", "G"));
            this.addStation("D", Arrays.asList("B"));
            this.addStation("E", Arrays.asList("B", "F"));
            this.addStation("F", Arrays.asList("E", "G"));
            this.addStation("G", Arrays.asList("C", "F", "H"));
            this.addStation("H", Arrays.asList("G", "I", "J"));
            this.addStation("I", Arrays.asList("H"));
            this.addStation("J", Arrays.asList("H", "K"));
            this.addStation("K", Arrays.asList("J", "L"));
            this.addStation("L", Arrays.asList("K"));
        }
    }
}

