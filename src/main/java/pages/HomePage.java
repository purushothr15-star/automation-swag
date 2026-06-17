package pages;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage {

    protected WebDriver driver;
    ReusableMethods ru;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        ru = new ReusableMethods(driver);
        //System.out.println("LogInPage driver ->" + driver);
    }
    @FindBy(xpath="//span[contains(text(), 'Products')]")
    public WebElement productsHeader;

    @FindBy(xpath="//nav[@class='bm-item-list']/a")
    public List<WebElement> menuItems;

    @FindBy(id="react-burger-menu-btn")
    public WebElement reactBurgerMenubtn;

    public boolean verifyMenus(){
        reactBurgerMenubtn.click();
        boolean menusMatch = false;
        List<String> actualMenus = new ArrayList<String>();
        ru.waitForElementToBeDisplayed(menuItems, 3);
        for(WebElement ele:menuItems){
            String tempEle=ele.getText();
            actualMenus.add(tempEle);
        }

        List<String> expectedMenu = Arrays.asList(ConfigReader.getProperty("menus").split(","));
        if(actualMenus.equals(expectedMenu)){
            System.out.println("Menus displayed as expected");
            menusMatch = true;
        }
        else{
            System.out.println("Menus not displayed as expected");
        }
        return menusMatch;
    }


}
