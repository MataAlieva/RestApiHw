import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiSpec {

    public static final String API_KEY = "reqres-free-v1";

    public static RequestSpecification baseSpec = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in")
            .addHeader("x-api-key", API_KEY)
            .setContentType(ContentType.JSON)
            .build();
}
