package testbase;

import config.ConfigReader;
import driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Properties;

//import static driverfactory.DriverFactory.prop;

public class BaseTest extends DriverFactory{
    //DriverFactory df = new DriverFactory();
    protected WebDriver driver;
    public void initBrowser() {
        ConfigReader.loadProperties();
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

   public void tearDown(){
       driver.quit();
   }



}
