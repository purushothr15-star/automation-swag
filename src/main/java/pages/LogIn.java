package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.BaseTest;

public class LogIn extends BaseTest {


    @FindBy(id="user-name")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement passWord;

    @FindBy(id="login-button")
    public WebElement loginBtn;

    @FindBy(xpath="//div[@class='app_logo']")
    public WebElement titleName;


    //initiallize page objects
    public LogIn(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
