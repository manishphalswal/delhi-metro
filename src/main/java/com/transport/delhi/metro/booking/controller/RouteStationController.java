package com.transport.delhi.metro.booking.controller;

import com.transport.delhi.metro.booking.exception.InvalidMetroLineException;
import com.transport.delhi.metro.booking.service.IRouteService;
import com.transport.delhi.metro.common.enums.MetroLine;
import com.transport.delhi.metro.common.enums.MetroStation;
import com.transport.delhi.metro.common.validation.RequestValidator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@AllArgsConstructor
public class RouteStationController {

    private IRouteService routeService;

    private RequestValidator<String> stationValidator;

    @GetMapping(value = "/stations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getStations() {
        return MetroStation.getAllStationNames();
    }

    @GetMapping(value = "/line/{metroLine}/stations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getMetroLineStations(@PathVariable @NonNull String metroLine) {
        MetroLine actualMetroLine;
        try {
            actualMetroLine = MetroLine.valueOf(metroLine.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException exception) {
            throw new InvalidMetroLineException("Invalid metro line: " + metroLine);
        }
        return MetroStation.getStationNamesOnLine(actualMetroLine);
    }

    @GetMapping(value = "/stations/{fromStation}/to/{toStation}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getStationsBetween(@PathVariable @NonNull String fromStation, @PathVariable @NonNull String toStation) {

        stationValidator.validate(fromStation);
        stationValidator.validate(toStation);

        return routeService.findRoute(fromStation, toStation);
    }
}
