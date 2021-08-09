package utils;

import Exceptions.InvalidPropertiesException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    private final static Properties properties;
    static {
        String filePath = "src/main/resources/configs.properties";
        try(FileInputStream fis = new FileInputStream(filePath)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException exception) {
            throw new InvalidPropertiesException("Invalid properties: " + filePath, exception);
        }
    }

    public static String getStringProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    public static int getNumericProperty(String propertyName) {
        return Integer.parseInt(properties.getProperty(propertyName));
    }
}
