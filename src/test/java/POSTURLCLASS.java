import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class POSTURLCLASS {
    ResponseSpecification responseSpecification200 = null;
    ResponseSpecification responseSpecification405 = null;
    RequestSpecification requestSpecification = null;
    static Properties prop = new Properties();
    private static InputStream configeFile;
    private static String apiKey;
    private static String baseUrl;

    @BeforeAll

    static void initTest() throws IOException{
        configeFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configeFile);

        apiKey = prop.getProperty("apiKey");
        baseUrl = prop.getProperty("baseUrl2");
    }

    @BeforeEach

    void beforeTest(){
        responseSpecification200 = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();

        responseSpecification405 = new ResponseSpecBuilder()
                .expectStatusCode(405)
                .expectStatusLine("HTTP/1.1 405 Method Not Allowed")
                .expectContentType("text/html;charset=utf-8")
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", getApiKey())
                .addQueryParam("includeNutrition", "false")
                .log(LogDetail.ALL)
                .build();

    }

    public static String getApiKey(){return apiKey;}

    public static String getBaseUrl(){return baseUrl;}
}
