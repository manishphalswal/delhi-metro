package com.transport.delhi.metro.booking.controller;

import com.transport.delhi.metro.booking.model.Booking;
import com.transport.delhi.metro.booking.service.IBookingService;
import com.transport.delhi.metro.common.validation.RequestValidator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
public class BookingController {

    private RequestValidator<BookingRequest> requestValidator;

    private IBookingService bookingService;

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public Booking createBooking(@RequestBody BookingRequest bookingRequest) {
        //Cross cutting concern: Validate bookingRequest
        requestValidator.validate(bookingRequest);

        return bookingService.createBooking(bookingRequest.getSourceStation(), bookingRequest.getDestinationStation());
    }
}
