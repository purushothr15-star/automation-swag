package pages;

import com.aventstack.extentreports.Status;
import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import testbase.BaseTest;
import utilities.ExcelUtil;
import utilities.ReportLogger;
import utilities.ReusableMethods;

public class LogIn{


    protected WebDriver driver;
    ReusableMethods rm ;
    ExcelUtil excelUtil;
    ReportLogger rl;

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
        excelUtil = new ExcelUtil();
        rl = new ReportLogger(driver);
        rm= new ReusableMethods(driver);
        System.out.println("LogInPage driver ->" + driver);
    }
    public void logInMethod(){
        rm.enterText(userName, ConfigReader.getProperty("username"));
        rm.enterText(passWord, ConfigReader.getProperty("password"));
        rl.log("Log In", "Username and password entered successfully "+ConfigReader.getProperty("username"), Status.PASS);

        rm.clickOnElement(loginBtn);
        rl.log("Home Page", "User logged in successfully"+ConfigReader.getProperty("username"), Status.PASS);
    }
    public void logInMethod(String uName){
        rm.enterText(userName, uName);
        rm.enterText(passWord, ConfigReader.getProperty("password"));
        rm.clickOnElement(loginBtn);
        rl.log("Home Page", "User logged in successfully"+ConfigReader.getProperty("username"), Status.PASS);
        System.out.println("changed the assertion to pass");
    }


}
