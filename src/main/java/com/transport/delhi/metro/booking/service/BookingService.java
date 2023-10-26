package com.transport.delhi.metro.booking.service;

import com.transport.delhi.metro.booking.model.Booking;
import com.transport.delhi.metro.booking.model.BookingDetail;
import com.transport.delhi.metro.booking.utils.BookingIdGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Slf4j
@Service
@AllArgsConstructor
public class BookingService implements IBookingService {

    private IFareCalculatorService fareCalculatorService;

    private BookingIdGenerator bookingIdGenerator;

    @Override
    public Booking createBooking(@NotNull String source, @NotNull String destination) {
        Double fare = fareCalculatorService.calculateFare(source, destination);
        Booking booking = newBooking(source, destination, fare);
        log.info("Booking created successfully with bookingId:" + booking.getBookingId());
        return booking;
    }

    private Booking newBooking(String source, String destination, Double fare) {
        String bookingId = bookingIdGenerator.generateBookingId();

        //Generate token here - Can be separate api/service or microservice for token generation
        return new Booking(bookingId, newBookingDetail(source, destination, fare));
    }

    private BookingDetail newBookingDetail(String source, String destination, Double fare) {
        return new BookingDetail(source, destination, fare);
    }
}
