package tests;

import base.TestBase;
import lombok.PatchBodyLombok;
import lombok.PatchResponseLombok;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.BaseSpecs;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PatchUpdateUserExtendedTest extends TestBase {

    @Test
    @DisplayName("Успешное частичное обновление пользователя (PATCH)")
    public void patchUpdateUserSuccessfulTest() {

        int userId = 2;

        PatchBodyLombok body = new PatchBodyLombok();
        body.setName("morpheus");
        body.setJob("zion resident");

        PatchResponseLombok response = step(
                "Отправка PATCH-запроса на обновление пользователя " + userId,
                () ->
                        given(BaseSpecs.requestSpec)
                                .pathParam("userId", 2)
                                .body(body)
                                .when()
                                .patch("users/{userId}")
                                .then()
                                .spec(BaseSpecs.responseSpecification(200))
                                .extract().body().as(PatchResponseLombok.class));

        step("Проверка ответа PATCH", () -> {
            assertEquals("morpheus", response.getName(), "Имя должно совпадать");
            assertEquals("zion resident", response.getJob(), "Job должен совпадать");
            assertNotNull(response.getUpdatedAt(), "updatedAt должен быть заполнен");
        });
    }
}