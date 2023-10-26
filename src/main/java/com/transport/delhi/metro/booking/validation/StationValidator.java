package com.transport.delhi.metro.booking.validation;

import com.transport.delhi.metro.booking.exception.InvalidStationException;
import com.transport.delhi.metro.common.validation.RequestValidator;
import com.transport.delhi.metro.common.enums.MetroStation;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

import static com.transport.delhi.metro.booking.utils.ConstantUtils.INVALID_STATION_MSG;

@Component
public class StationValidator implements RequestValidator<String> {
    @Override
    public boolean validate(@NotNull String station) {
        boolean valid = MetroStation.getStationForName(station) != null;
        if (!valid) {
            throw new InvalidStationException(INVALID_STATION_MSG.replace("{station}", station != null ? station : "null"));
        }

        return Boolean.TRUE;
    }
}
