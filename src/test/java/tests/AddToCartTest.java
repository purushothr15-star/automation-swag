package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddToCart;
import pages.LogIn;
import testbase.BaseTest;

public class AddToCartTest extends BaseTest {


    public static AddToCart atc;
    public static LogIn logI;
    @BeforeMethod
    public void setUp(){
        logI = new LogIn(driver);
        atc = new AddToCart(driver);
        //System.out.println("Test Driver = " + driver);
    }

    @Test
    public void addingToCartTest(){
        logI.logInMethod();

        atc.addToCart();
    }
    @Test
    public void removeFromCartTest(){
        logI.logInMethod();
        atc.addToCart();
        atc.removeFrmCrt();
      //  Assert.assertTrue(false);
    }

    @Test
    public void continueShoppingTest(){
            logI.logInMethod();
            atc.addToCart();
            atc.continueShoping();
    }
}
