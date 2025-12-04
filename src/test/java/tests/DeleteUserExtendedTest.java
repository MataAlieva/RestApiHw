package tests;

import base.TestBase;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.BaseSpecs;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteUserExtendedTest extends TestBase {

    @Test
    @DisplayName("Успешное удаление пользователя")
    public void deleteUserSuccessfulTest() {

        Response response = given(BaseSpecs.requestSpec)
                .pathParam("userId", 2)
                .when()
                .delete("/users/{userId}");

        step("Проверка: статус 204", () -> {
            assertEquals(204, response.getStatusCode(), "Статус должен быть 204");
        });

        step("Проверка: тело ответа пустое", () -> {
            assertEquals("", response.getBody().asString(), "Тело ответа должно быть пустым");
        });
    }
}

