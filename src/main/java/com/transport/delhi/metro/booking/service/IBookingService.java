package com.transport.delhi.metro.booking.service;

import com.transport.delhi.metro.booking.model.Booking;

public interface IBookingService {
    Booking createBooking(String source, String destination);
}
