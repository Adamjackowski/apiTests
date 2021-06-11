package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

import io.restassured.response.ValidatableResponse;

public class AppTest {

    @Test
    public void testRequestResponse() {
        
        String URL = "https://api.github.com/users/octocat";
        ValidatableResponse response = given()
        .when()
        .get(URL)
        .then();
        validateStatusCode(response, "200");
        validateResponseBody(response);
    }

    public void validateStatusCode(ValidatableResponse response, String statusCode) {
        response
            .statusCode(Integer.parseInt(statusCode));
    }
    
    public void validateResponseBody(ValidatableResponse response) {
        response.body("login", equalTo("octocat"));
        response.body("id", equalTo(583231));
        response.body("name", equalTo("The Octocat"));
    }
}