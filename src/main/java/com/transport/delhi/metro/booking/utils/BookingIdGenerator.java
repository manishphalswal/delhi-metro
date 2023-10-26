package com.transport.delhi.metro.booking.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

/*
 Thread safe class to generate bookingId
 */
@Component
public final class BookingIdGenerator {
    private final Random random = new Random();
    private static final int MAX_BOOKING_ID = 999999999;

    public String generateBookingId() {
        synchronized (this) {
            int randomNum = this.random.nextInt(MAX_BOOKING_ID);
            return zeroPad(randomNum, 9);
        }
    }

    private String zeroPad(int value, int width) {
        return String.format("%0" + width + "d", value);
    }
}
