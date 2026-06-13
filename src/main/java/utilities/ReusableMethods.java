package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.BaseTest;

import java.time.Duration;

public class ReusableMethods extends BaseTest {

    private WebDriver driver = getDriver();
    public void enterText(WebElement element, String text){
        element.sendKeys(text);
    }

    public void clickOnElement(WebElement element){
        element.click();
    }


    public void waitForElementToBeDisplayed(WebElement element , int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
