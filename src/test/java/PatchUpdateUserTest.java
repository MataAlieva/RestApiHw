import base.TestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PatchUpdateUserTest extends TestBase {

    @Test
    @DisplayName("Успешное частичное обновление пользователя (PATCH)")
    public void patchUpdateUserSuccessfulTest() {

        given()
                .log().all()
                .header(header)
                .contentType(ContentType.JSON)
                .pathParam("userId", 2)
                .body("{\"name\":\"morpheus\",\"job\":\"zion resident\"}")
                .when()
                .patch("/users/{userId}")
                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion resident"))
                .body("updatedAt", notNullValue());
    }
    @Test
    @DisplayName("Частичное обновление пользователя — пустое тело")
    public void patchUpdateEmptyBodyTest() {
        given()
                .log().all()
                .header(header)
                .contentType(ContentType.JSON)
                .pathParam("userId", 2)
                .body("{}")
                .when()
                .patch("/users/{userId}")
                .then()
                .log().body()
                .statusCode(200)
                .body("updatedAt", notNullValue());

    }
}