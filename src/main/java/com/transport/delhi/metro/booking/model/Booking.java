package com.transport.delhi.metro.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking implements Serializable {

    private static final long serialVersionUID = 213213213123L;

    private String bookingId;
    private BookingDetail bookingDetail;
}
