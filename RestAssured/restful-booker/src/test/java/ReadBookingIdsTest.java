import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class ReadBookingIdsTest extends BaseTest {
    static final String basePath = "/booking";
    @Test
    public void readBookingIdsTest() {
        Response response = given()
                .when()
                .get(baseUrl + basePath)
                .then()
                .extract()
                .response();

        Assertions.assertEquals(200, response.getStatusCode());

    }
}