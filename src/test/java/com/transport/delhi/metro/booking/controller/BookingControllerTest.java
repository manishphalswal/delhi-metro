package com.transport.delhi.metro.booking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transport.delhi.metro.booking.model.Booking;
import com.transport.delhi.metro.booking.model.BookingDetail;
import com.transport.delhi.metro.booking.service.BookingService;
import com.transport.delhi.metro.common.validation.RequestValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @MockBean
    private BookingService bookingService;

    @MockBean
    private RequestValidator<BookingRequest> requestValidator;

    @Autowired
    MockMvc mockMvc;

    @Test
    void createBooking() throws Exception {
        BookingRequest bookingRequest = new BookingRequest("A", "B");
        Booking booking = new Booking("123456789", new BookingDetail("A", "B", 10.0));

        when(requestValidator.validate(bookingRequest)).thenReturn(true);
        when(bookingService.createBooking("A", "B")).thenReturn(booking);

        // Convert MyObject to a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(bookingRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/bookings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonBody))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(result -> {
                    Booking bookingResponse = objectMapper.readValue(result.getResponse().getContentAsByteArray(), Booking.class);
                    assertNotNull(bookingResponse);
                    assertEquals("123456789", bookingResponse.getBookingId());
                });
    }
}