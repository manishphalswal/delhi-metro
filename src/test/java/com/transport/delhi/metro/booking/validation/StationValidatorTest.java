package com.transport.delhi.metro.booking.validation;

import com.transport.delhi.metro.booking.exception.InvalidStationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StationValidatorTest {

    @InjectMocks
    private StationValidator stationValidator;

    @Test
    void validateSuccess() {
        boolean actual = stationValidator.validate("A");
        assertTrue(actual);
    }

    @Test
    void validateInvalidStation() {
        assertThrows(InvalidStationException.class, () -> stationValidator.validate("Invalid"));
    }

    @Test
    void validateNullStation() {
        assertThrows(InvalidStationException.class, () -> stationValidator.validate(null));
    }
}