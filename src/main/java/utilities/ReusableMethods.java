package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import testbase.BaseTest;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class ReusableMethods {

    private WebDriver driver;
    public ReusableMethods(WebDriver driver){
        this.driver = driver;
    }
    public void enterText(WebElement element, String text){
        element.sendKeys(text);
    }

    public void clickOnElement(WebElement element){
        boolean removeDisplayed= waitForElementToBeDisplayed(element, 3);
        if(removeDisplayed){
            element.click();
        }
    }


    public boolean waitForElementToBeDisplayed(WebElement element , int time){
        boolean displayed=false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
        if(element.isDisplayed()){
            displayed = true;
        }
        return displayed;
    }
}
