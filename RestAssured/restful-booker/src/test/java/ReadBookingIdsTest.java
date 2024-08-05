import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;

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