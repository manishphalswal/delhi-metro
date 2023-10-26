package com.transport.delhi.metro.common.enums;

import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.transport.delhi.metro.common.enums.MetroLine.*;

@AllArgsConstructor
public enum MetroStation {
    A(1, "A", Arrays.asList(BLUE, PURPLE)),
    B(2, "B", Arrays.asList(BLUE, YELLOW)),
    C(3, "C", Arrays.asList(PURPLE)),
    D(4, "D", Arrays.asList(BLUE)),
    E(5, "E", Arrays.asList(YELLOW)),
    F(6, "F", Arrays.asList(YELLOW)),
    G(7, "G", Arrays.asList(YELLOW, PURPLE, RED)),
    H(8, "H", Arrays.asList(RED, VIOLET)),
    I(9, "I", Arrays.asList(RED)),
    J(10, "J", Arrays.asList(VIOLET)),
    K(11, "K", Arrays.asList(VIOLET)),
    L(12, "L", Arrays.asList(VIOLET));

    private final Integer id;
    private final String stationName;
    private final List<MetroLine> associatedMetroLines;

    public static MetroStation getStationForName(String name) {
        if (!StringUtils.hasLength(name)) {
            return null;
        }
        return Arrays.stream(MetroStation.values())
                .filter(station -> station.stationName.equals(name))
                .findFirst()
                .orElse(null);
    }

    public static List<String> getStationNamesOnLine(MetroLine metroLine) {
        return Arrays.stream(MetroStation.values())
                .filter(station -> station.associatedMetroLines.contains(metroLine))
                .map(station -> station.stationName)
                .collect(Collectors.toList());
    }

    public static List<String> getAllStationNames() {
        return Arrays.stream(MetroStation.values())
                .map(station -> station.stationName)
                .collect(Collectors.toList());
    }
}
