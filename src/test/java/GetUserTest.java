import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetUserTest extends TestBase {

    @Test
    @DisplayName("Получение несуществующего пользователя — 404 Not Found")
    public void getUserTest() {

        given()
                .log().all()
                .header(header)
                .pathParam("userId", 23)
                .when()
                .get("/users/{userId}")
                .then()
                .log().all()
                .statusCode(404)
                .body(equalTo("{}"));
    }
}