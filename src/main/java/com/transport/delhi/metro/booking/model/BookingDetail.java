package com.transport.delhi.metro.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetail implements Serializable {

    private static final long serialVersionUID = 2132132133232L;

    private String sourceStation;
    private String destinationStation;
    private Double fare;
}
