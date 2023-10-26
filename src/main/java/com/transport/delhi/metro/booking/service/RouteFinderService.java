package com.transport.delhi.metro.booking.service;

import com.transport.delhi.metro.booking.referencedata.MetroRoute;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.*;

@Service
@AllArgsConstructor
public class RouteFinderService implements RouteFinder {

    private MetroRoute metroRoute;

    @Override
    public List<String> findRoute(@NotNull String startStation, @NotNull String endStation) {
        Map<String, String> parentMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(startStation);
        visited.add(startStation);

        while (!queue.isEmpty()) {
            String currentStation = queue.poll();

            if (currentStation.equals(endStation)) {
                return constructPath(parentMap, startStation, endStation);
            }

            for (String neighbor : metroRoute.getStationAdjacencyList().get(currentStation)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, currentStation);
                }
            }
        }

        return new ArrayList<>(); // No path found
    }



    private List<String> constructPath(Map<String, String> parentMap, String start, String end) {
        List<String> path = new ArrayList<>();
        String currentStation = end;
        while (!currentStation.equals(start)) {
            path.add(currentStation);
            currentStation = parentMap.get(currentStation);
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }
}
