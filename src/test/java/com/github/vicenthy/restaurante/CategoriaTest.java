package com.github.vicenthy.restaurante;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class CategoriaTest {
    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/categoria")
          .then()
             .statusCode(200);
    }
}
