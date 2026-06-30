package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReportUtil;
import testbase.BaseTest;
import utilities.ReportLogger;
import utilities.ScreenShotUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestListener  implements ITestListener {

   // ExtentTest test;


    ExtentReports extent = ExtentReportUtil.getInstance();
    //ScreenShotUtil su = new ScreenShotUtil();
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("LISTENER STARTED");
        ReportLogger.test = extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportLogger.test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ReportLogger.test.fail(result.getThrowable());

        /*String path = ScreenShotUtil.getScreenShot(result.getMethod().getMethodName());

        try{
            File file = new File(path);
            ReportLogger.test.addScreenCaptureFromPath(file.getAbsolutePath());
        }
        catch(Exception e){
            e.printStackTrace();
        }*/

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

    }
}




    //have you used override concept any where in you project?
    /*ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onTestStart(ITestResult result){
        ReportLogger.test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        ReportLogger.test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        ReportLogger.test.fail(result.getThrowable());

        String path = ScreenShotUtils.captrueScreenShot(base.BaseTest.driver, result.getMethod().getMethodName());

        try{
            ReportLogger.test.addScreenCaptureFromPath(path);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }*/

