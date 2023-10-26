package com.transport.delhi.metro.booking.referencedata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MetroFareTest {

    private final MetroFare metroFare = new MetroFare();

    @BeforeEach
    public void setup() {
        metroFare.initFare();
    }

    @Test
    void calculateFareMin() {
        Double actualFare = metroFare.calculateFare(1);
        assertNotNull(actualFare);
        assertEquals(10.0, actualFare);
    }

    @Test
    void calculateFareMedium() {
        Double actualFare = metroFare.calculateFare(14);
        assertNotNull(actualFare);
        assertEquals(35.0, actualFare);
    }

    @Test
    void calculateFareMax() {
        Double actualFare = metroFare.calculateFare(45);
        assertNotNull(actualFare);
        assertEquals(60.0, actualFare);
    }

    @Test
    void calculateFareInvalidStationCount() {
        Double actualFare = metroFare.calculateFare(-1);
        assertNotNull(actualFare);
        assertEquals(0.0, actualFare);
    }
}