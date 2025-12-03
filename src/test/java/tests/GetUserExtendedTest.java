package tests;

import base.TestBase;
import lombok.GetResponseLombok;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.GetSpec;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUserExtendedTest extends TestBase {

    @Test
    @DisplayName("Получение несуществующего пользователя — 404 Not Found")
    public void getUserNotFoundTest() {

        GetResponseLombok response = step("Отправка запроса на получение пользователя", () ->
                given(GetSpec.GetRequestSpec)
                        .pathParam("userId", 23)
                        .when()
                        .get("/users/{userId}")
                        .then()
                        .statusCode(404)
                        .extract().body().as(GetResponseLombok.class)
        );

        step("Проверка: данные пользователя пустые", () -> {
            assertEquals(null, response.getData(), "Данные пользователя должны быть пустыми");
        });
    }
}