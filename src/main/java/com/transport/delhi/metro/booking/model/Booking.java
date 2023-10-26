package com.transport.delhi.metro.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Booking {
    private String bookingId;
    private BookingDetail bookingDetail;
}
