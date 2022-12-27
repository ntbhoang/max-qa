package max.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    private static String pwd = System.getProperty("user.dir");

    private static Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(
                pwd + "/src/test/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ReadPropertyFile() {}

    public static String get(Enum key){
        return properties.getProperty(key.toString());
    }
}
