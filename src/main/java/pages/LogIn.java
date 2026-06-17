package pages;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import testbase.BaseTest;
import utilities.ReusableMethods;

public class LogIn{

    protected WebDriver driver;
    ReusableMethods rm = new ReusableMethods(driver);
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
        PageFactory.initElements(this.driver, this);
        //System.out.println("LogInPage driver ->" + driver);
    }
    public void logInMethod(){
        rm.enterText(userName, ConfigReader.getProperty("username"));
        rm.enterText(passWord, ConfigReader.getProperty("password"));
        rm.clickOnElement(loginBtn);
    }


}
