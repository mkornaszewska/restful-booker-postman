import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateBookingTest extends BaseTest {
    private static Faker faker;
    private String randomFirstName;
    private String randomLastName;

    @BeforeAll
    static void beforeAll() {
        faker = new Faker();

    }

    @BeforeEach
    void beforeEach() {
        getToken();
        randomFirstName = faker.name().firstName();
        randomLastName = faker.name().lastName();

    }

    @Test
    public void updateBookingTest() {

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2024-07-27");
        bookingdates.put("checkout", "2024-08-16");

        JSONObject booking = new JSONObject();
        booking.put("firstname", randomFirstName);
        booking.put("lastname", randomLastName);
        booking.put("totalprice", 444);
        booking.put("depositpaid", true);
        booking.put("bookingdates", bookingdates);
        booking.put("additionalneeds", "Breakfast");

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie",
                        "token=" + "6381bea117459ab")
                .pathParam("id", 1461)
                .body(booking.toString())
                .when()
                .put(baseUrl + basePath + "{id}")
                .then()
                .extract()
                .response();

        Assertions.assertEquals(200, response.getStatusCode());

        JsonPath json = response.jsonPath();
        Assertions.assertEquals(randomFirstName, json.getString("firstname"));

    }

    @Test
    public void partialUpdateBookingTest() {

        JSONObject booking = new JSONObject();
        booking.put("firstname", randomFirstName);

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + "6381bea117459ab")
                .pathParam("id", 1461)
                .body(booking.toString())
                .when()
                .patch(baseUrl + basePath + "{id}")
                .then()
                .extract()
                .response();

        Assertions.assertEquals(200, response.getStatusCode());

        JsonPath json = response.jsonPath();
        Assertions.assertEquals(randomFirstName, json.getString("firstname"));

    }

}
