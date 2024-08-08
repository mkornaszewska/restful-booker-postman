package requests;

import com.github.mkornaszewska.secrets.RestfulBookerSecrets;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

    protected static RequestSpecBuilder requestBuilder;

    public static RequestSpecification requestSetup(){
        requestBuilder = new RequestSpecBuilder();
        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.addQueryParam("authorization", "token=" + RestfulBookerSecrets.getToken());
        return requestBuilder.build();

    }
}
