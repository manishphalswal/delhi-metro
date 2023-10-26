package com.transport.delhi.metro.booking.service;

import com.transport.delhi.metro.booking.referencedata.MetroFare;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FareCalculatorServiceTest {

    @InjectMocks
    private FareCalculatorService fareCalculatorService;

    @Mock
    private RouteFinder routeFinder;

    @Mock
    private MetroFare metroFare;

    @Test
    void calculateFare() {

        when(routeFinder.findRoute("A", "B")).thenReturn(Arrays.asList("A", "B"));
        when(metroFare.calculateFare(1)).thenReturn(10.0);

        Double actualFare = fareCalculatorService.calculateFare("A", "B");
        assertNotNull(actualFare);
        assertEquals(10.0, actualFare);

        verify(routeFinder, times(1)).findRoute("A", "B");
        verify(metroFare, times(1)).calculateFare(1);
    }

    @Test
    void calculateFareInvalidStation() {

        when(routeFinder.findRoute("A", "invalid")).thenReturn(Collections.emptyList());
        when(metroFare.calculateFare(-1)).thenReturn(0.0);

        Double actualFare = fareCalculatorService.calculateFare("A", "invalid");
        assertNotNull(actualFare);
        assertEquals(0.0, actualFare);

        verify(routeFinder, times(1)).findRoute("A", "invalid");
        verify(metroFare, times(1)).calculateFare(-1);
    }
}