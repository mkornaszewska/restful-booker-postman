package requests.booking;

import io.restassured.response.Response;
import requests.BaseRequest;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {
    public static Response getAllBookingsRequest(){

        return given()
                .spec(BaseRequest.requestSetup())
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .extract()
                .response();
    }
}
