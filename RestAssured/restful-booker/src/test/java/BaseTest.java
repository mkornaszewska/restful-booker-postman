import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class BaseTest {
    static final String baseUrl = "https://restful-booker.herokuapp.com/";
    static final String basePath = "booking/";

    public void String getToken() {

        JSONObject auth = new JSONObject();
        auth.put("username", "admin");
        auth.put("password", "password123");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(auth.toString())
                .when()
                .put(baseUrl + "/auth")
                .then()
                .extract()
                .response();

    }
}

