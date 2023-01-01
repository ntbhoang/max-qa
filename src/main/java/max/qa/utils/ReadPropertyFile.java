package max.qa.utils;

import max.qa.constants.Constants;
import max.qa.enums.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    private static Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(
                Constants.getConfigFilePath())) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ReadPropertyFile() {}

    public static String get(Configuration key){
        return properties.getProperty(key.toString());
    }
}
