package com.transport.delhi.metro.booking.validation;

import com.transport.delhi.metro.booking.controller.BookingRequest;
import com.transport.delhi.metro.booking.exception.InvalidBookingRequestException;
import com.transport.delhi.metro.common.enums.MetroStation;
import com.transport.delhi.metro.common.validation.RequestValidator;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.transport.delhi.metro.booking.utils.ConstantUtils.INVALID_BOOKING_REQUEST_MSG;

@Component
public class BookingRequestValidator implements RequestValidator<BookingRequest> {


    @Override
    public boolean validate(@NonNull BookingRequest request) {
        List<String> invalidStations = new ArrayList<>();
        if (MetroStation.getStationForName(request.getSourceStation()) == null) {
            invalidStations.add(request.getSourceStation());
        }

        if (MetroStation.getStationForName(request.getDestinationStation()) == null) {
            invalidStations.add(request.getDestinationStation());
        }

        if (invalidStations.size() > 0) {
            throw new InvalidBookingRequestException(INVALID_BOOKING_REQUEST_MSG.replace("{stations}", invalidStations.toString()));
        }

        return Boolean.TRUE;
    }
}
