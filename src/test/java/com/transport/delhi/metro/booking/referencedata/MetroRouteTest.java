package com.transport.delhi.metro.booking.referencedata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MetroRouteTest {

    private final MetroRoute metroRoute = new MetroRoute();

    @BeforeEach
    public void setup() {
        metroRoute.init();
    }

    @Test
    void addStation() {
        int beforeAddCount = metroRoute.getStationAdjacencyList().size();

        metroRoute.addStation("test", Arrays.asList("test1", "test2"));

        assertEquals(beforeAddCount + 1, metroRoute.getStationAdjacencyList().size());
        assertNotNull(metroRoute.getStationAdjacencyList().get("test"));
        assertEquals(2, metroRoute.getStationAdjacencyList().get("test").size());
    }

    @Test
    void getStationAdjacencyList() {
        assertNotNull(metroRoute.getStationAdjacencyList());
        assertNotNull(metroRoute.getStationAdjacencyList().get("A"));
    }
}