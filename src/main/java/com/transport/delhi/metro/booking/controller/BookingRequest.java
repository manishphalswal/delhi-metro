package com.transport.delhi.metro.booking.controller;

import lombok.Data;

@Data
public class BookingRequest {
    private String sourceStation;
    private String destinationStation;
}
