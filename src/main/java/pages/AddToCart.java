package pages;

import com.aventstack.extentreports.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import testbase.BaseTest;
import utilities.ReusableMethods;

public class AddToCart{

    protected WebDriver driver;
    ReusableMethods ru;
    HomePage home;
    public AddToCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        ru= new ReusableMethods(driver);
        home = new HomePage(driver);
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

        System.out.println("backPackName = " + backPackName);
        String slBackNme = backPackName.getText();
        backPackaddToCart.click();
        cartLink.click();
        ru.waitForElementToBeDisplayed(yourCart, 3);
        String actItemName = cartItemLabel.getText();
        if(actItemName.equalsIgnoreCase(slBackNme)){
            System.out.println("item added to card");
        }
        else{
            System.out.println("item not added to card");
        }
    }
    public void removeFrmCrt(){
        ru.clickOnElement(removeFrmCart);
        boolean removeCrtDisplayed = ru.waitForElementToBeDisplayed(removeFrmCart, 2);
        if(!removeCrtDisplayed){
            System.out.println(backPackName+" Removed from cart as expected");
        }
        else{
            System.out.println(backPackName+" Not removed from cart as expected");
        }
    }

    public boolean continueShoping(){

        continueShopping.click();
        boolean prdctHdrDispl = home.productsHeader.isDisplayed();
        if(prdctHdrDispl){
            System.out.println("System navigated to home page as expected");
        }
        else{
            System.out.println("System did not navigate to home page as expected");
        }
        return prdctHdrDispl;
    }


}
