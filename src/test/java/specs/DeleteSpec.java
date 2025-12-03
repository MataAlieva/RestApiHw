package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.equalTo;

public class DeleteSpec {
    public static RequestSpecification DeleteRequestSpec = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/api")
            .setContentType(ContentType.JSON)
            .build();

    public static ResponseSpecification DeleteResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .expectBody(equalTo(""))
            .build();
}
