import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class CreateBookingTest extends BaseTest {

    @Test
    public void createNewBookingTest() {

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2024-07-27");
        bookingdates.put("checkout", "2024-08-16");

        JSONObject booking = new JSONObject();
        booking.put("firstname", "Ana");
        booking.put("lastname", "Fabell");
        booking.put("totalprice", 444);
        booking.put("depositpaid", true);
        booking.put("bookingdates", bookingdates);
        booking.put("additionalneeds", "Breakfast");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(booking.toString())
                .when()
                .post(baseUrl + basePath)
                .then()
                .extract()
                .response();

        Assertions.assertEquals(200, response.getStatusCode());

        JsonPath json = response.jsonPath();
        Assertions.assertEquals("Ana", json.getString("booking.firstname"));

    }
}
