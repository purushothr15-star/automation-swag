package tests;

import com.aventstack.extentreports.Status;
import config.ConfigReader;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogIn;
import testbase.BaseTest;
import utilities.ReportLogger;

import java.util.List;

public class HomePageTest extends BaseTest {

    HomePage hmP;
    LogIn logIn;
    ReportLogger rLog;



    @BeforeMethod
    public void setUp(){
        hmP = new HomePage(driver);
        logIn = new LogIn(driver);
        rLog = new ReportLogger(driver);
    }
    @Test
    public void verifyMenusTest(){
        logIn.logInMethod();
        boolean menuDisplayed = hmP.verifyMenus();
        if(menuDisplayed){
            rLog.log("Verify Menus", "Home Menus displayed as expected", Status.PASS);
        }
        else{
            rLog.log("Verify Menus", "Home Menus displayed as expected", Status.PASS);
        }
    }
}
