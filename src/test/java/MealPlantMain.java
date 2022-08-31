import lesson4.ConnectUser;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "username",
        "firstName",
        "lastName",
        "email"
})
@Data
public class MealPlantMain{

    @JsonProperty("username")
    public String username;
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("email")
    public String email;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    static Properties prop = new Properties();
    private static InputStream configeFile;
    private static String apiKey;
    private static String baseUrl;



    @BeforeAll
    static void initTest() throws IOException {
        configeFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configeFile);

        apiKey = prop.getProperty("apiKey");
        baseUrl = prop.getProperty("baseUrl3");
    }

    public static String getApiKey(){return apiKey;}

    public static String getBaseUrl(){return baseUrl;}



}
