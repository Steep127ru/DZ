import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MealPlantTest extends MealPlantMain {
    @Test

    void ConnectUserMealPlanStatusCodeTest(){
       given()
                .queryParam("apiKey", getApiKey())
                .body("{\n"
                                + "\"username\": \"your user's name\", \n"
                        + "\"firstName\": \"your user's first name\", \n"
                        +" \"lastName\": \"your user's last name\", \n"
                        + "\"email\": \"your user's email\", \n" +
                        "}\n")
                .when()
                .post("https://api.spoonacular.com/users/connect")
                .then()
                .statusCode(200);

    }

    @Test

    void ConnectUserMealPlanStatusTest(){
       JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .body("{\n"
                        + "\"username\": \"your user's name\", \n"
                        + "\"firstName\": \"your user's first name\", \n"
                        +" \"lastName\": \"your user's last name\", \n"
                        + "\"email\": \"your user's email\", \n" +
                        "}\n")
                .when()
                .post("https://api.spoonacular.com/users/connect")
                .body()
               .jsonPath();
       assertThat(response.get("status"), equalTo("success"));
       System.out.print(response.get("username").toString());
       System.out.println();
       System.out.print(response.get("hash").toString());

    }




}
