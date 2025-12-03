import base.TestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateUserTest extends TestBase {

    @Test
    @DisplayName("Успешное создание пользователя (name + job)")
    public void createUserSuccessfulTest() {

        given()
                .log().all()
                .header(header)
                .contentType(ContentType.JSON)
                .body("{\"name\":\"morpheus\",\"job\":\"leader\"}")
                .when()
                .post("/users")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }
}