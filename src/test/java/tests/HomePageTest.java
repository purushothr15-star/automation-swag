package tests;

import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogIn;
import testbase.BaseTest;

import java.util.List;

public class HomePageTest extends BaseTest{

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
