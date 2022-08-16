import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;

import javax.naming.NamingEnumeration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Test extends AbstractTest{

    // https://api.spoonacular.com/recipes/complexSearch


    @org.junit.jupiter.api.Test

    void getStatus200Test(){
        given()
                .when()
                .get(getBaseUrl() + "?query=pasta&number=1" + "&apiKey=" + getApiKey()).
                then()
                .statusCode(200);
    }

    @org.junit.jupiter.api.Test

    void getNumberTest(){
        JsonPath response = given()
                .when()
                .get(getBaseUrl() + "?query=pasta&number=1" + "&apiKey=" + getApiKey())
                .body()
                .jsonPath();
        assertThat(response.get("number"), equalTo(1));
    }

    @org.junit.jupiter.api.Test

    void getOffsetTest(){
        JsonPath response = given()
                .when()
                .get(getBaseUrl() + "?query=pasta&number=1" + "&apiKey=" + getApiKey())
                .body()
                .jsonPath();
        assertThat(response.get("offset"), equalTo(0));
    }

    @org.junit.jupiter.api.Test

    void getTitleNameTest(){
        JsonPath respone = given()
                .when()
                .get(getBaseUrl() + "?query=pasta&number=1" + "&apiKey=" + getApiKey())
                .body()
                .jsonPath();
        assertThat(respone.get("results[0].title"), equalTo("Pasta With Tuna"));
    }

    @org.junit.jupiter.api.Test

    void getIDTest(){
        JsonPath respone = given()
                .when()
                .get(getBaseUrl() + "?query=pasta&number=1" + "&apiKey=" + getApiKey())
                .body()
                .jsonPath();
        assertThat(respone.get("results[0].id"), equalTo(654959));
    }
@org.junit.jupiter.api.Test

    void getStatus405Test(){
        given()
                .when()
                .post(getBaseUrl() + "?apiKey=" + getApiKey())
                .then()
                .statusCode(405);
    }
}
