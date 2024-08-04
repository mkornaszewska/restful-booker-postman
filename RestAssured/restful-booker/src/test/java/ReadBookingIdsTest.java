import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;

import static io.restassured.RestAssured.*;

public class ReadBookingIdsTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking";
    }

    @Test
    public void statusCodeTest() {
        ValidatableResponse response =
                when()
                        .request("GET", baseURI)
                        .then()
                        .assertThat().statusCode(200);
    }

    @Test
    public void contentTypeTest() {
        ValidatableResponse response =
                when()
                        .request("GET", baseURI)
                        .then()
                        .assertThat().contentType("text/html; charset=UTF-8");
    }

//    @Test
//    public void jsonSchemaTest() {
//        InputStream getBookingIdsJsonSchema = getClass().getClassLoader()
//                .getResourceAsStream("getbookingidsschema.json");
//        ValidatableResponse response =
//                when()
//                        .request("GET", baseURI)
//                        .then()
//                        .assertThat().body(JsonSchemaValidator.matchesJsonSchema("getbookingidsschema.json"));
//    }
}