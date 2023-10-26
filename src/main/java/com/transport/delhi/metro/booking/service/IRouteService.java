package com.transport.delhi.metro.booking.service;

import java.util.List;

public interface IRouteService {
    List<String> findRoute(String source, String destination);
}
