package com.pascal.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfig {
    private LoadConfig() {
        loadConfig();
    }

    private static LoadConfig instance = new LoadConfig();

    public static LoadConfig getInstance() {
        return instance;
    }

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    private void loadConfig() {
        Properties prop = new Properties();
        try (InputStream input = LoadConfig.class.getClassLoader().getResourceAsStream("service.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            //load a properties file from class path, inside static method
            prop.load(input);
            //get the property value and print it out
            //System.out.println(prop.getProperty("db.url"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.properties = prop;
    }

    public static void main(String[] args) {
        LoadConfig loadConfig = LoadConfig.getInstance();
        Properties properties = loadConfig.getProperties();
        System.out.println(properties.getProperty("kafka_ip"));
    }

}
