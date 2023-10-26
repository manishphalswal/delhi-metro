package com.transport.delhi.metro.booking.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingRequest {
    private String sourceStation;
    private String destinationStation;
}
