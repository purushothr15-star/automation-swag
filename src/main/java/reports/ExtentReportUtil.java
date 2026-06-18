package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil{

    public static ExtentReports extent;
    //public static ExtentTest test;

    public static ExtentReports getInstance(){
        if(extent ==null){
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            spark.config().setReportName("Automation Report Swag Labs");
            spark.config().setDocumentTitle("Execution Report");
            extent = new ExtentReports();
            extent.attachReporter(spark);

        }
        return extent;
    }
}

 /*if(extent ==null){
ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            spark.config().setReportName("Automation Report");
            spark.config().setDocumentTitle("Execution Report");
extent = new ExtentReports();
            extent.attachReporter(spark);
        }
                return extent;*/
