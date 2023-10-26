package com.transport.delhi.metro.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingDetail {
    private String sourceStation;
    private String destinationStation;
    private Double fare;
}
