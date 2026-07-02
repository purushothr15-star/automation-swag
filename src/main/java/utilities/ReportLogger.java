package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.aventstack.extentreports.Status.PASS;

public class ReportLogger {

    public WebDriver driver;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    ScreenShotUtil su ;
    SoftAssert softAssert;


    public ReportLogger(WebDriver driver){
        this.driver=driver;
        su = new ScreenShotUtil();
        softAssert = new SoftAssert();
    }
    public void log(String logText, String info, Status status){
            String path = su.getScreenShot(logText);
            try{
                File file = new File(path);
                if(status==status.PASS) {
                    test.get().pass(logText+ "-"+info).addScreenCaptureFromPath(path);
                }
                else if(status==status.FAIL){
                    softAssert.assertTrue(false);
                    test.get().fail(logText+"-"+info).addScreenCaptureFromPath(path);
                    softAssert.assertAll();
                }
            }
            catch(SecurityException e){
                e.printStackTrace();
            }
    }

}

/*
 public static ExtentTest test;

    public static void log(String logText, String info, String value){
        String path =
                ScreenShotUtils.captrueScreenShot(
                        BaseTest.driver,
                        logText
                );
        try{
            File file = new File(path);
            ReportLogger.test.info(
                    logText + value
            ).addScreenCaptureFromPath(file.getAbsolutePath());

        } catch (Exception e) {
          e.printStackTrace();
        }
    }
 */
