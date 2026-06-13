package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddToCart;
import pages.LogIn;
import testbase.BaseTest;

public class AddToCartTest extends BaseTest {

    LogInTest logT = new LogInTest();

    public static AddToCart atc;
    public static LogIn logI;
    @BeforeMethod
    public void setUp(){
        initBrowser();
         atc= new AddToCart(driver);
        logI = new LogIn(driver);
    }

    @Test
    public void addingToCart(){
        logT.logIn();
        atc.addToCart();
    }
}
