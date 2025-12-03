package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.equalTo;

public class GetSpec {
    public static RequestSpecification GetRequestSpec = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .build();

    public static ResponseSpecification GetResponse404Spec = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .expectBody(equalTo("{}"))
            .log(LogDetail.ALL)
            .build();
}
