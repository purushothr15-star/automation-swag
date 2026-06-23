package pages;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import testbase.BaseTest;
import utilities.ReportLogger;
import utilities.ReusableMethods;

public class AddToCart{

    protected WebDriver driver;
    ReusableMethods ru;
    HomePage home;
    ReportLogger rLog;
    public AddToCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        ru= new ReusableMethods(driver);
        home = new HomePage(driver);
        rLog = new ReportLogger(driver);
        //System.out.println("Add To Cart driver ->"+driver);
    }

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement backPackaddToCart;

    @FindBy(className="shopping_cart_link")
    WebElement cartLink;

    @FindBy(className="inventory_item_name")
    WebElement cartItemLabel;

    @FindBy(xpath="//div[contains(text(),'Sauce Labs Backpack')]")
    WebElement backPackName;

    @FindBy(xpath="//span[contains(text(),'Your Cart')]")
    WebElement yourCart;

    @FindBy(id="remove-sauce-labs-backpack")
    WebElement removeFrmCart;

    @FindBy(id="continue-shopping")
    WebElement continueShopping;






    public void addToCart(){

        //System.out.println("backPackName = " + backPackName);
        String slBackNme = backPackName.getText();
        backPackaddToCart.click();
        rLog.log("Add to cart", "Adding" +slBackNme+"to cart", Status.PASS);
        cartLink.click();
        if(ru.waitForElementToBeDisplayed(yourCart, 3)){
            rLog.log("Add to cart Page", "Add to cart page displayed", Status.PASS);
        }
        else{
            rLog.log("Add to cart Page", "Add to cart page not displayed", Status.FAIL);
        }
        String actItemName = cartItemLabel.getText();
        if(actItemName.equalsIgnoreCase(slBackNme)){
            rLog.log("Added to cart Page", "Added"+slBackNme+"added to cart page", Status.PASS);
            System.out.println("item added to card");
        }
        else{
            rLog.log("Added to cart Page", "Added"+slBackNme+"added to cart page", Status.FAIL);
            System.out.println("item not added to card");
        }
    }
    public void removeFrmCrt(){
        ru.clickOnElement(removeFrmCart);
        boolean removeCrtDisplayed = ru.waitForElementToBeDisplayed(removeFrmCart, 2);
        if(!removeCrtDisplayed){
            rLog.log("Remove from cart Page", "Removed item from added to cart page", Status.PASS);
            System.out.println(backPackName+" Removed from cart as expected");
        }
        else{
            rLog.log("Remove from cart Page", "Not Removed item from added to cart page", Status.PASS);
            System.out.println(backPackName+" Not removed from cart as expected");
        }
    }

    public boolean continueShoping(){

        continueShopping.click();
        boolean prdctHdrDispl = ru.waitForElementToBeDisplayed(home.productsHeader, 3);
        if(prdctHdrDispl){
            rLog.log("Continue Shopping", "Continue shopping clicked and browser navigated to home page", Status.PASS);
            System.out.println("System navigated to home page as expected");
        }
        else{
            rLog.log("Continue Shopping", "Continue shopping clicked and browser not navigated to home page", Status.FAIL);
            System.out.println("System did not navigate to home page as expected");
        }
        return prdctHdrDispl;
    }


}
