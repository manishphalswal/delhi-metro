package com.transport.delhi.metro.token.model;

import com.transport.delhi.metro.common.enums.MetroStation;

import java.time.LocalDateTime;

public class Token {
    private String tokenId;
    private MetroStation issuingStation;
    private MetroStation destinationStation;
    private String entryGateNumber;
    private LocalDateTime issueDateTime;
    private Double fare;

}
