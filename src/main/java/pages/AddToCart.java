package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import testbase.BaseTest;
import utilities.ReusableMethods;

public class AddToCart{

    protected WebDriver driver;

    public AddToCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        System.out.println("Add To Cart driver ->"+driver);
    }
    ReusableMethods ru = new ReusableMethods(driver);
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
        if(!removeFrmCart.isDisplayed()){
            System.out.println(backPackName+" Removed from cart as expected");
        }
        else{
            System.out.println(backPackName+" Not removed from cart as expected");
        }
    }


}
