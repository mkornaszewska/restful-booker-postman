import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReadBookingTest extends BaseTest {

    @Test
    public void readAllBookingIdsTest() {
        Response response = given()
                .when()
                .get(baseUrl + basePath)
                .then()
                .extract()
                .response();

        Assertions.assertEquals(200, response.getStatusCode());

        JsonPath json = response.jsonPath();
        List<Object> bookingids = json.getList("bookingid");
        Assertions.assertTrue(bookingids.size() > 0);
    }

    @Test
    public void readOneBookingTest() {
        Response response = given()
                .pathParams("id", 309)
                .when()
                .get(baseUrl + basePath + "{id}");


        Assertions.assertEquals(200, response.getStatusCode());

        JsonPath json = response.jsonPath();
        Assertions.assertEquals("Jeromy", json.getString("firstname"));
    }

    @Test
    public void readFilteredBookingTest() {
        Response response = given()
                .queryParam("firstname", "Kraig")
                .when()
                .get(baseUrl + basePath);

        Assertions.assertEquals(200, response.getStatusCode());

        JsonPath json = response.jsonPath();
        List<Object> bookingids = json.getList("bookingid");
        Assertions.assertTrue(bookingids.size() > 0);
    }
}