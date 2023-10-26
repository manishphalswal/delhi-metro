package com.transport.delhi.metro.booking.validation;

import com.transport.delhi.metro.booking.controller.BookingRequest;
import com.transport.delhi.metro.booking.exception.InvalidBookingRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class BookingRequestValidatorTest {

    @InjectMocks
    private BookingRequestValidator validator;

    @Test
    void validateOK() {
        BookingRequest request = dummyValidRequest();
        assertTrue(validator.validate(request));
    }

    @Test
    void validateInvalidRequest() {
        assertThrows(InvalidBookingRequestException.class, () -> validator.validate(dummyInValidRequest()));
    }

    @Test
    void validateInvalidRequestWithNull() {
        assertThrows(InvalidBookingRequestException.class, () -> validator.validate(dummyInValidRequestWithNull()));
    }

    private BookingRequest dummyValidRequest() {
        return new BookingRequest("A", "C");
    }

    private BookingRequest dummyInValidRequest() {
        return new BookingRequest("sourceTest", "destinationTest");
    }

    private BookingRequest dummyInValidRequestWithNull() {
        return new BookingRequest(null, "destinationTest");
    }
}