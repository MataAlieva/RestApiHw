import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqresUserTests {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader("x-api-key", "reqres-free-v1")
                .build();
    }

    @Test
    public void updateUserSuccessfulTest() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"name\":\"morpheus\",\"job\":\"zion resident\"}")
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion resident"));
    }

    @Test
    public void updateUserEmptyBodyTest() {
        given()
                .contentType(ContentType.JSON)
                .body("{}")
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200);
    }

    @Test
    public void updateUserNameTest() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"name\":\"neo\"}")
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .body("name", equalTo("neo"));
    }

    @Test
    public void updateUserJobTest() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"job\":\"the one\"}")
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .body("job", equalTo("the one"));
    }

    @Test
    public void updateUserEmptyFieldsTest() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"name\":\"\",\"job\":\"\"}")
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .body("name", equalTo(""))
                .body("job", equalTo(""));
    }
}