package tests;

import com.aventstack.extentreports.Status;
import config.ConfigReader;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LogIn;
import testbase.BaseTest;
import utilities.ExcelUtil;
import utilities.ReportLogger;
import utilities.ReusableMethods;

import static java.lang.Math.log;

public class LogInTest extends BaseTest {
    ReusableMethods rm;
    LogIn login;
    static ExcelUtil excelUtil;
    ReportLogger log;
    @BeforeMethod
    public void setUp(){
        //initBrowser();
        login = new LogIn(driver);
        rm  = new ReusableMethods(driver);
        excelUtil = new ExcelUtil();
        log = new ReportLogger(driver);
        //System.out.println("LogIntest driver ->" + driver);
    }

    @DataProvider
    public static Object[][] getData(){
            Object[][] data = new Object[2][1];
                data[0][0]=excelUtil.getData("LogIn", "User Id", 1);
                data[1][0]=excelUtil.getData("LogIn", "User Id", 2);

            return data;
    }

    @Test(dataProvider= "getData")
    public void logInDiffUsersTest(String uName){

        login.logInMethod(uName);
    }

    @Test
    public void logInTest(){
        login.logInMethod();
        String title = ConfigReader.getProperty("titleName");
        rm.waitForElementToBeDisplayed(login.titleName, 3);
        String actualTitle = login.titleName.getText();
        Assert.assertEquals(actualTitle, title);
        if(actualTitle.equalsIgnoreCase(title)){
            log.log("Home Page Title", "Title displayed as expected"+actualTitle, Status.PASS);
            System.out.println("title displayed as expected");
        }
        else {
            log.log("Home Page Title", "Title not displayed as expected"+actualTitle, Status.FAIL);
            System.out.println("title is not displayed as expected");
        }
    }
    @AfterMethod
    public void closeBrowser(){
        System.out.println(driver);
        tearDown();

    }

}
