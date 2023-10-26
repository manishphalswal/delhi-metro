package com.transport.delhi.metro.booking.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BookingIdGeneratorTest {

    private final BookingIdGenerator bookingIdGenerator = new BookingIdGenerator();

    @Test
    void generateBookingId() {
        String bookingId = bookingIdGenerator.generateBookingId();
        assertNotNull(bookingId);
        assertEquals(9, bookingId.length());
    }

    @Test
    void generateBookingIdWithConcurrency() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        List<Callable<String>> callableList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            callableList.add(bookingIdGenerator::generateBookingId);
        }

        List<Future<String>> futureList = executorService.invokeAll(callableList);
        Set<String> uniqueBookingIds = futureList.stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException e) {
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        assertNotNull(uniqueBookingIds);
        assertEquals(1000, uniqueBookingIds.size());
        assertFalse(uniqueBookingIds.contains(null));
    }
}