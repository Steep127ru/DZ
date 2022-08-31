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
                .spec(requestSpecification)
                .when()
                .get(getBaseUrl())
                .then()
                .spec(responseSpecification405);
    }

    @Test

    void postStatus200Test(){
        given()
                .spec(requestSpecification)
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Homemade Garlic and Basil French Fries")
                .when()
                .post(getBaseUrl())
                .then()
                .spec(responseSpecification200);
    }

    @Test

    void confidenceTest(){
        JsonPath response = given()
                .spec(requestSpecification)
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
                .spec(requestSpecification)
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
                .spec(requestSpecification)
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
