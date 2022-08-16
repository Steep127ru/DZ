import io.restassured.path.json.JsonPath;
import jdk.jfr.internal.consumer.RecordingInput;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Test2 extends POSTURLCLASS{
    @Test

    void getStatus405Test(){
        given()
                .when()
                .get(getBaseUrl() + "?apiKey=" + getApiKey())
                .then()
                .statusCode(405);
    }

    @Test

    void postStatus200Test(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Homemade Garlic and Basil French Fries")
                .when()
                .post(getBaseUrl())
                .then()
                .statusCode(200);
    }

    @Test

    void confidenceTest(){
        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Homemade Garlic and Basil French Fries")
                .when()
                .post(getBaseUrl())
                .body()
                .jsonPath();
        assertThat(response.get("confidence"), equalTo(0.85F));
    }

    @Test

    void cuisineTest(){
        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Homemade Garlic and Basil French Fries")
                .when()
                .post(getBaseUrl())
                .body()
                .jsonPath();
        assertThat(response.get("cuisine"), equalTo("Mediterranean"));
    }

    @Test

    void cuisinesTest(){
        JsonPath respinse = given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Homemade Garlic and Basil French Fries")
                .when()
                .post(getBaseUrl())
                .body()
                .jsonPath();
        assertThat(respinse.get("cuisines[0]"), equalTo("Mediterranean"));
        assertThat(respinse.get("cuisines[1]"), equalTo("European"));
        assertThat(respinse.get("cuisines[2]"), equalTo("French"));
    }

}
