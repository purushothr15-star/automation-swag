package tests;

import config.ConfigReader;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogIn;
import testbase.BaseTest;
import utilities.ReusableMethods;

public class LogInTest extends BaseTest {
    ReusableMethods rm;
    LogIn login;
    @BeforeMethod
    public void setUp(){
        //initBrowser();
        login = new LogIn(driver);
        rm  = new ReusableMethods(driver);
        //System.out.println("LogIntest driver ->" + driver);
    }

    @Test
    public void logInTest(){
        login.logInMethod();
        String title = ConfigReader.getProperty("titleName");
        rm.waitForElementToBeDisplayed(login.titleName, 3);
        String actualTitle = login.titleName.getText();
        Assert.assertEquals(actualTitle, title);
        if(actualTitle.equalsIgnoreCase(title)){
            System.out.println("title displayed as expected");
        }
        else {
            System.out.println("title is not displayed as expected");
        }
    }
    @AfterMethod
    public void closeBrowser(){
        tearDown();
    }

}
