package tests;

import config.ConfigReader;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogIn;
import testbase.BaseTest;

import java.util.List;

public class HomePageTest extends BaseTest implements WebDriverListener {

    HomePage hmP;
    LogIn logIn;



    @BeforeMethod
    public void setUp(){
        hmP = new HomePage(driver);
        logIn = new LogIn(driver);
    }
    @Test
    public void verifyMenus(){
        logIn.logInMethod();
        Assert.assertTrue(hmP.verifyMenus());
    }
}
