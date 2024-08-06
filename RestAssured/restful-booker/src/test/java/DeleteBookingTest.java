import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest extends BaseTest {
    @Test
    public void deleteBookingTest(){
        Response response = given()
                .header("Cookie", "token=" + "8fe0f667a9eca59")
                .pathParam("id", 2375)
                .when()
                .delete(baseUrl + basePath + "{id}")
                .then()
                .extract()
                .response();

        Assertions.assertEquals(201, response.getStatusCode());
    }
}
