package com.transport.delhi.metro.booking.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

/*
 Thread safe class to generate bookingId
 */
@Component
public final class BookingIdGenerator {
    private final Random random = new Random();

    public Integer generateBookingId() {
        synchronized (this) {
            return this.random.nextInt(Integer.MAX_VALUE);
        }
    }
}
