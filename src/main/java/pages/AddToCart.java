package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.BaseTest;
import utilities.ReusableMethods;

public class AddToCart  extends BaseTest {


    public AddToCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    ReusableMethods ru = new ReusableMethods();
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



    public void addToCart(){

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


}
