package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class PatchSpec {
    public static RequestSpecification PatchRequestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .contentType(ContentType.JSON);

    public static final io.restassured.specification.ResponseSpecification PatchResponseSpec =
            new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .build();
}
