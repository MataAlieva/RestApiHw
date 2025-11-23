import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DeleteUserTest extends TestBase {
    @Test
    @DisplayName("Успешное удаление пользователя")
    public void deleteUserSuccessfulTest() {

        given()
                .log().all()
                .header(header)
                .contentType(ContentType.JSON)
                .pathParam("userId", 2)
                .when()
                .delete("/users/{userId}")
                .then()
                .log().all()
                .statusCode(204)
                .body(equalTo(""));
    }
}
