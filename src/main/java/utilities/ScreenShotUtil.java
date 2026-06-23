package utilities;

import driverfactory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtil {

    static DriverFactory driverFactory = new DriverFactory();

    //private static WebDriver driver = driverFactory.getDriver();

    /*public ScreenShotUtil(){

        System.out.println("Screen shot driver->"+driver);
    }*/
    public static String   getScreenShot(String screenShotName){
        WebDriver driver = DriverFactory.getDriver();
        System.out.println(driver);
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String path = "test-output/screenshots/"+screenShotName+"-"+timeStamp+".png";
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(path);
        try{
            FileUtils.copyFile(src, dest);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    return path;
    }
}

/*
public static String captrueScreenShot(WebDriver driver, String screenshotName){
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String path = "screenshots/" + screenshotName+"_"+timeStamp+".png";

            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);

            try{
                FileUtils.copyFile(src, dest );

            }
            catch (IOException e){
                e.printStackTrace();
            }
        return path;
    }
 */
