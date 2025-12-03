package specs;

import base.TestBase;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class CreateSpec {
    public static RequestSpecification CreateRequestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .log().headers()
            .header(TestBase.header)
            .contentType(ContentType.JSON)
            .basePath("/api/users");

    public static ResponseSpecification CreateResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(STATUS)
            .log(BODY)
            .build();
}
