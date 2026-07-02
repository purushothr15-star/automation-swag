package driverfactory;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    // public static Properties prop;

    public static WebDriver initializeDriver()  {
        String browserName = ConfigReader.getProperty("browser");
        String execution = ConfigReader.getProperty("execution");
        try {
            if (execution.equalsIgnoreCase("local")) {
                createLocalDriver(browserName);
            }
            else{
                createRemoteDriver(browserName);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return driver.get();
    }
    private static void createLocalDriver(String browser)
            throws Exception {

        switch (browser.toLowerCase()) {

            case "chrome":
                ChromeOptions options = new ChromeOptions();

                Map<String, Object> prefs = new HashMap<>();

                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.password_manager_leak_detection", false);
                options.setExperimentalOption("prefs", prefs);
                driver.set(new ChromeDriver(options));

                break;

            case "edge":

                driver.set(new EdgeDriver());

                break;

            default:

                throw new RuntimeException("Invalid Browser");

        }

    }

    private static void createRemoteDriver(String browser)
            throws Exception {

        String gridUrl =
                ConfigReader.getProperty("gridURL");

        switch (browser.toLowerCase()) {

            case "chrome":
                ChromeOptions options = new ChromeOptions();

                Map<String, Object> prefs = new HashMap<>();

                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.password_manager_leak_detection", false);
                options.setExperimentalOption("prefs", prefs);
                try {
                    driver.set(new RemoteWebDriver(new URL(gridUrl), options));
                }
                catch(MalformedURLException e){
                    throw new RuntimeException(e);
                }

                break;

            case "edge":

                EdgeOptions edge =
                        new EdgeOptions();

                driver.set(new RemoteWebDriver(
                        new URL(gridUrl),
                        edge));

                break;

            default:

                throw new RuntimeException("Invalid Browser");

        }

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


