package com.transport.delhi.metro.booking.controller;

import com.transport.delhi.metro.booking.service.IFareCalculatorService;
import com.transport.delhi.metro.common.validation.RequestValidator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fare")
@AllArgsConstructor
public class FareController {

    private IFareCalculatorService fareCalculatorService;

    private RequestValidator<String> stationValidator;

    @GetMapping(value = "/stations/{fromStation}/to/{toStation}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double calculateFare(@PathVariable @NonNull String fromStation, @PathVariable @NonNull String toStation) {

        stationValidator.validate(fromStation);
        stationValidator.validate(toStation);

        return fareCalculatorService.calculateFare(fromStation, toStation);
    }

}
