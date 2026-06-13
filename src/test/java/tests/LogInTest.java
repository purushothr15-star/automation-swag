package tests;

import config.ConfigReader;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogIn;
import testbase.BaseTest;
import utilities.ReusableMethods;

public class LogInTest extends BaseTest {
    ReusableMethods rm = new ReusableMethods();
    LogIn login;
    @BeforeMethod
    public void setUp(){
        initBrowser();
        login = new LogIn(driver);
    }

    @Test
    public void logIn(){
        rm.enterText(login.userName, ConfigReader.getProperty("username"));
        rm.enterText(login.passWord, ConfigReader.getProperty("password"));
        rm.clickOnElement(login.loginBtn);
        String title = driver.getTitle();
        System.out.println(title);
    }
    @AfterMethod
    public void closeBrowser(){
        tearDown();
    }

}
