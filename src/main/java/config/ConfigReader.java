package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static void loadProperties(){
        try{
            prop = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Users\\aishw\\PurushothProjects\\swag-labs-automation\\src\\main\\java\\config\\config.properties");
            prop.load(fis);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }
}
