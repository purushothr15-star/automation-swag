package testbase;

import config.ConfigReader;
import driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

//import static driverfactory.DriverFactory.prop;

public class BaseTest extends DriverFactory{
    //DriverFactory df = new DriverFactory();
    protected WebDriver driver;

    @BeforeMethod
    public void initBrowser() {
        ConfigReader.loadProperties();
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterMethod
   public void tearDown(){
        System.out.println(driver);
        if(driver!=null) {
            driver.quit();
        }
   }



}
