import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;

import javax.naming.NamingEnumeration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Test extends AbstractTest{

    // https://api.spoonacular.com/recipes/complexSearch


    @org.junit.jupiter.api.Test

    void getStatus405Test(){
        given()
                .spec(requestSpecification)
                .when()
                .post(getBaseUrl())
                .then()
                .spec(responseSpecification405);
    }

    @org.junit.jupiter.api.Test


    void getStatus200Test(){
        given()
                .spec(requestSpecification)
                .when()
                .get(getBaseUrl()).
                then()
                .spec(responseSpecification200);
    }

    @org.junit.jupiter.api.Test

    void getNumberTest(){
        JsonPath response = given()
                .spec(requestSpecification)
                .when()
                .get(getBaseUrl())
                .body()
                .jsonPath();
        assertThat(response.get("number"), equalTo(10));
    }

    @org.junit.jupiter.api.Test

    void getOffsetTest(){
        JsonPath response = given()
                .spec(requestSpecification)
                .when()
                .get(getBaseUrl())
                .body()
                .jsonPath();
        assertThat(response.get("offset"), equalTo(0));
    }

    @org.junit.jupiter.api.Test

    void getTitleNameTest(){
        JsonPath respone = given()
                .spec(requestSpecification)
                .when()
                .get(getBaseUrl())
                .body()
                .jsonPath();
        assertThat(respone.get("results[0].title"), equalTo("Cauliflower, Brown Rice, and Vegetable Fried Rice"));
    }

    @org.junit.jupiter.api.Test

    void getIDTest(){
        JsonPath respone = given()
                .spec(requestSpecification)
                .when()
                .get(getBaseUrl())
                .body()
                .jsonPath();
        assertThat(respone.get("results[0].id"), equalTo(716426));
    }

}
