package tests;

import base.TestBase;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import lombok.CreateBodyLombok;
import lombok.CreateResponseLombok;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.BaseSpecs;


import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CreateUserExtendedTest extends TestBase {

    @Test
    @DisplayName("Успешное создание пользователя (name + job)")
    public void createUserSuccessfulSpecTest() {

        CreateBodyLombok authData = new CreateBodyLombok();
        authData.setName("morpheus");
        authData.setJob("leader");

        CreateResponseLombok response = step("Make request", () ->
                given(BaseSpecs.requestSpec)
                        .body(authData)
                        .when()
                        .post()
                        .then()
                        .spec(BaseSpecs.responseSpecification(201))
                        .extract().body().as(CreateResponseLombok.class)
        );

        step("Check response", () -> {
            assertEquals("morpheus", response.getName());
            assertEquals("leader", response.getJob());
            assertNotNull(response.getId());
            assertNotNull(response.getCreatedAt());
        });
    }
}