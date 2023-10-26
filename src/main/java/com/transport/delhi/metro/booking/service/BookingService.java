package com.transport.delhi.metro.booking.service;

import com.transport.delhi.metro.booking.model.Booking;
import com.transport.delhi.metro.booking.model.BookingDetail;
import com.transport.delhi.metro.booking.utils.BookingIdGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService implements IBookingService {

    private IFareCalculatorService fareCalculatorService;

    private BookingIdGenerator bookingIdGenerator;

    @Override
    public Booking createBooking(String source, String destination) {
        Double fare = fareCalculatorService.calculateFare(source, destination);
        return newBooking(source, destination, fare);
    }

    private Booking newBooking(String source, String destination, Double fare) {
        Integer bookingId = bookingIdGenerator.generateBookingId();

        //Generate token here: TODO
        return new Booking(bookingId.toString(), newBookingDetail(source, destination, fare));
    }

    private BookingDetail newBookingDetail(String source, String destination, Double fare) {
        return new BookingDetail(source, destination, fare);
    }
}
