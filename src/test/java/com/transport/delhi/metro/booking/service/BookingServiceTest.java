package com.transport.delhi.metro.booking.service;

import com.transport.delhi.metro.booking.model.Booking;
import com.transport.delhi.metro.booking.referencedata.MetroRoute;
import com.transport.delhi.metro.booking.utils.BookingIdGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @InjectMocks
    private BookingService bookingService;

    @Mock
    private FareCalculatorService fareCalculatorService;

    private BookingIdGenerator bookingIdGenerator;

    @BeforeEach
    public void setup() {
        bookingIdGenerator = new BookingIdGenerator();
        ReflectionTestUtils.setField(bookingService, "bookingIdGenerator", bookingIdGenerator);
    }

    @Test
    void createBooking() {
        when(fareCalculatorService.calculateFare("A", "B")).thenReturn(10.0);

        Booking booking = bookingService.createBooking("A", "B");
        assertNotNull(booking);
        assertNotNull(booking.getBookingId());
        assertEquals(9, booking.getBookingId().length());
        assertNotNull(booking.getBookingDetail());
        assertEquals(10.0, booking.getBookingDetail().getFare());
        assertEquals("A", booking.getBookingDetail().getSourceStation());
        assertEquals("B", booking.getBookingDetail().getDestinationStation());
    }
}