package com.solvd.api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String getValue(String value) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));

            return properties.getProperty(value);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
