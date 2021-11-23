package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static Properties loadProperties(String propertyFile) {
        Properties config = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(propertyFile);
            config.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }
}
