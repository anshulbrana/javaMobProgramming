package services.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Configuration {
    private static Configuration instance;
    private Properties properties;

    private Configuration(){

    }

    public static synchronized Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
            Properties properties = new Properties();

            String confFile = System.getProperty("conf.file");
            try {
                properties.load(new FileInputStream(confFile));
            } catch (IOException e) {
                //To handle the file not found or read exception
                e.printStackTrace();
            }

            instance.properties = properties;
        }
        return instance;
    }


    //Instead of having hard coded value on PassengerDAO we hardcode here

    public String getDBUser() {
        return properties.getProperty("db.user");
    }

    public String getDBPassword() {
        return properties.getProperty("db.password");
    }

    public String getDBUrl() {
        return properties.getProperty("db.url");
    }

}
