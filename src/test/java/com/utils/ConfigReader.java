package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String readProperty(String key){
        File file = new File("configuration.properties");
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));//load method will load every value from file object to the properties object
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
                //more actions surround by try and catch.
    }

}
