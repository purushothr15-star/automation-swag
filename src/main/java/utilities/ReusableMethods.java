package utilities;

import org.openqa.selenium.WebElement;

public class ReusableMethods {


    public static void enterText(WebElement element, String text){
        element.sendKeys(text);
    }

    public static void clickOnElement(WebElement element){
        element.click();
    }

}
