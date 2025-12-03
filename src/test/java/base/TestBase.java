package base;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static final Header header = new Header("x-api-key", "reqres_52a1efc2142943098724898a3e26d2ce");

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
    }
}