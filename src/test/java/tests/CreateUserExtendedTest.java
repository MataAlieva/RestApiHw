package tests;

import base.TestBase;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import lombok.CreateBodyLombok;
import lombok.CreateResponseLombok;
import models.CreateBodyModel;
import models.CreateResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.CreateSpec;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CreateUserExtendedTest extends TestBase {

    @Test
    @DisplayName("Успешное создание пользователя (name + job)")
    public void createUserSuccessfulTest() {
        CreateBodyModel authData = new CreateBodyModel();
        authData.setName("morpheus");
        authData.setJob("leader");

        CreateResponseModel response = given()
                .log().all()
                .header(TestBase.header)
                .contentType(ContentType.JSON)
                .body(authData)
                .when()
                .post("/users")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .extract().body().as(CreateResponseModel.class);
        assertEquals("morpheus", response.getName());
        assertEquals("leader", response.getJob());
        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }

    @Test
    @DisplayName("Успешное создание пользователя (name + job)")
    public void createUserSuccessfulLombokTest() {

        CreateBodyLombok authData = new CreateBodyLombok();
        authData.setName("morpheus");
        authData.setJob("leader");

        CreateResponseLombok response = given()
                .log().all()
                .header(TestBase.header)
                .contentType(ContentType.JSON)
                .body(authData)
                .when()
                .post("/users")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .extract().body().as(CreateResponseLombok.class);
        assertEquals("morpheus", response.getName());
        assertEquals("leader", response.getJob());
        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }

    @Test
    @DisplayName("Успешное создание пользователя (name + job)")
    public void createUserSuccessfulAllureTest() {

        CreateBodyLombok authData = new CreateBodyLombok();
        authData.setName("morpheus");
        authData.setJob("leader");

        CreateResponseLombok response = given()
                .filter(new AllureRestAssured())
                .log().all()
                .header(TestBase.header)
                .contentType(ContentType.JSON)
                .body(authData)
                .when()
                .post("/users")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .extract().body().as(CreateResponseLombok.class);
        assertEquals("morpheus", response.getName());
        assertEquals("leader", response.getJob());
        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }

    @Test
    @DisplayName("Успешное создание пользователя (name + job)")
    public void createUserSuccessfulCustomAllureTest() {

        CreateBodyLombok authData = new CreateBodyLombok();
        authData.setName("morpheus");
        authData.setJob("leader");

        CreateResponseLombok response = given()
                .filter(withCustomTemplates())
                .log().all()
                .header(TestBase.header)
                .contentType(ContentType.JSON)
                .body(authData)
                .when()
                .post("/users")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .extract().body().as(CreateResponseLombok.class);
        assertEquals("morpheus", response.getName());
        assertEquals("leader", response.getJob());
        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }

    @Test
    @DisplayName("Успешное создание пользователя (name + job)")
    public void createUserSuccessfulStepsTest() {

        CreateBodyLombok authData = new CreateBodyLombok();
        authData.setName("morpheus");
        authData.setJob("leader");

        CreateResponseLombok response = step("Make request", () ->
                given()
                        .filter(withCustomTemplates())
                        .log().all()
                        .header(TestBase.header)
                        .contentType(ContentType.JSON)
                        .body(authData)
                        .when()
                        .post("/users")
                        .then()
                        .log().body()
                        .statusCode(201)
                        .body("name", equalTo("morpheus"))
                        .body("job", equalTo("leader"))
                        .extract().body().as(CreateResponseLombok.class));


        step("Check response", () ->
                assertEquals("morpheus", response.getName()));
        assertEquals("leader", response.getJob());
        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }

    @Test
    @DisplayName("Успешное создание пользователя (name + job)")
    public void createUserSuccessfulSpecTest() {

        CreateBodyLombok authData = new CreateBodyLombok();
        authData.setName("morpheus");
        authData.setJob("leader");

        CreateResponseLombok response = step("Make request", () ->
                given(CreateSpec.CreateRequestSpec)
                        .body(authData)
                .when()
                        .post()
                .then()
                        .spec(CreateSpec.CreateResponseSpec)
                        .extract().body().as(CreateResponseLombok.class));

        step("Check response", () ->
        assertEquals("morpheus", response.getName()));
        assertEquals("leader", response.getJob());
        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }
}