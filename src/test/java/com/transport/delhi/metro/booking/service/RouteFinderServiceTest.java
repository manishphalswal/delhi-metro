package com.transport.delhi.metro.booking.service;

import com.transport.delhi.metro.booking.referencedata.MetroRoute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RouteFinderServiceTest {

    @InjectMocks
    private RouteFinderService routeFinder;

    private MetroRoute route;

    @BeforeEach
    public void setup() {
        route = new MetroRoute();
        route.init();
        ReflectionTestUtils.setField(routeFinder, "metroRoute", route);
    }

    @Test
    void findRoute() {
        List<String> stationList = routeFinder.findRoute("A", "D");
        assertNotNull(stationList);
        assertEquals(3, stationList.size());
        assertTrue(stationList.contains("A"));
        assertTrue(stationList.contains("B"));
        assertTrue(stationList.contains("D"));
    }

    @Test
    void findRouteInvalidStation() {
        List<String> stationList = routeFinder.findRoute("A", "invalid");
        assertNotNull(stationList);
        assertEquals(0, stationList.size());
    }

    @Test
    void findRouteNullStation() {
        List<String> stationList = routeFinder.findRoute("A", null);
        assertNotNull(stationList);
        assertEquals(0, stationList.size());
    }

}