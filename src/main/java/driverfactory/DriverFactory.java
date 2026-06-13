package driverfactory;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
   private WebDriver driver;
  // public static Properties prop;

    public WebDriver initializeDriver(){
        String browserName = ConfigReader.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        return driver;
    }

    public WebDriver getDriver(){
        return driver;
    }
}


