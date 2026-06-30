package driverfactory;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DriverFactory {
   private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
  // public static Properties prop;

    public static WebDriver initializeDriver(){
        String browserName = ConfigReader.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            //driver = new ChromeDriver();
            /*ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-notifications");*/
            ChromeOptions options = new ChromeOptions();

            Map<String, Object> prefs = new HashMap<>();

            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false);
            options.setExperimentalOption("prefs", prefs);
            driver.set(new ChromeDriver(options));
        }
        else if(browserName.equalsIgnoreCase("edge")){
            EdgeOptions options = new EdgeOptions();
            driver.set(new EdgeDriver(options));
        }
        return driver.get();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    // Quit browser
    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();

        }
    }
}


