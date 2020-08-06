package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    public static String propFile(String propItem) {
        Properties properties = new Properties();
        FileInputStream file;
        try {
            file = new FileInputStream("localenvironment.properties");
            properties.load(file);
        } catch (IOException e) {
            e.getMessage();
        }
        return properties.getProperty(propItem);
    }
}
