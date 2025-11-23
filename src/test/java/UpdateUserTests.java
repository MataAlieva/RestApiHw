import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUserTests extends TestBase {

    private static final String UPDATE_USER_ENDPOINT = "/api/users/{userId}";

    @Test
    @DisplayName("Успешное обновление пользователя (name + job)")
    public void updateUserSuccessfulTest() {
        given()
                .header(header)
                .contentType(ContentType.JSON)
                .pathParam("userId", 2)
                .body("{\"name\":\"morpheus\",\"job\":\"zion resident\"}")
                .when()
                .put(UpdateUserTests.UPDATE_USER_ENDPOINT)
                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion resident"));
    }

    @Test
    @DisplayName("Обновление пользователя с пустым body {}")
    public void updateUserEmptyBodyTest() {
        given()
                .header(header)
                .contentType(ContentType.JSON)
                .pathParam("userId", 2)
                .body("{}")
                .when()
                .put(UPDATE_USER_ENDPOINT)
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    @DisplayName("Обновление только имени пользователя (name)")
    public void updateUserNameTest() {
        given()
                .header(header)
                .contentType(ContentType.JSON)
                .pathParam("userId", 2)
                .body("{\"name\":\"neo\"}")
                .when()
                .put(UPDATE_USER_ENDPOINT)
                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo("neo"));
    }

    @Test
    @DisplayName("Обновление только работы пользователя (job)")
    public void updateUserJobTest() {
        given()
                .header(header)
                .contentType(ContentType.JSON)
                .pathParam("userId", 2)
                .body("{\"job\":\"the one\"}")
                .when()
                .put(UPDATE_USER_ENDPOINT)
                .then()
                .log().body()
                .statusCode(200)
                .body("job", equalTo("the one"));
    }

    @Test
    @DisplayName("Обновление пользователя пустыми полями name=\"\" job=\"\"")
    public void updateUserEmptyFieldsTest() {
        given()
                .header(header)
                .contentType(ContentType.JSON)
                .pathParam("userId", 2)
                .body("{\"name\":\"\",\"job\":\"\"}")
                .put(UPDATE_USER_ENDPOINT)
                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(""))
                .body("job", equalTo(""));
    }
}