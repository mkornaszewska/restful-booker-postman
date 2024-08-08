package tests.booking;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import requests.booking.GetBookingRequest;

public class ReadBookingTest {
    @Test
    void readBookings() {
        final Response response = GetBookingRequest.getAllBookingsRequest();

        Assertions.assertThat(response.statusCode()).isEqualTo(200);    }

    @Test
    void readBooking() {
    }

}