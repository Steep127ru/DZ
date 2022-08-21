import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MealPlantMain {
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
