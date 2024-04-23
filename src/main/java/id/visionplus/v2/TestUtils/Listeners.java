package id.visionplus.v2.TestUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.IRetryAnalyzer;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import id.visionplus.v2.MainFunction.*;
import io.appium.java_client.android.AndroidDriver;

public class Listeners extends BaseTest implements ITestListener {
    
    AndroidDriver android;
    ExtentReports extent = ExtentReporterNG.getReporterObject();
    String path = System.getProperty("user.dir") + "/reports/" + timeStampDate + "/Automation Report"  + ".html";
    ExtentTest test;
    
    List<String> failedTestCaseLists = new ArrayList<>();
    String resultString="List of Failed Test Cases";    
    
    int totalTestCases = 0;
    int totalTestCasesFailed = 0;
    int totalTestCasesSkipped = 0;
    String failedTestCases ="";
    String skippedTestCases ="";
    String testSuitesName = "";

    @Override        
    public void onTestStart(ITestResult result) {           
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Script onStart method " + result.getName());
        totalTestCases++;
        
        String className = result.getTestClass().getName();
        String methodName = result.getMethod().getMethodName();
        
        System.out.println("Running Test Class: " + className + ", Method: " + methodName);

        ITestContext context = result.getTestContext();
        XmlSuite xmlSuite = context.getSuite().getXmlSuite();
        String suiteName = xmlSuite.getName();

        test.info("Test Suite: " + suiteName);
        testSuitesName=suiteName;
    }    
    
    @Override        
    public void onTestSuccess(ITestResult result) {                 
        test.log(Status.PASS, "Script " + result.getMethod().getMethodName() + " Successfully Running");
    }    
    
    @Override        
    public void onTestFailure(ITestResult result) {                 
        String methodName = result.getMethod().getMethodName();

        if (result.getMethod() instanceof IRetryAnalyzer) {
            IRetryAnalyzer retryAnalyzer = (IRetryAnalyzer) result.getMethod();
            if (retryAnalyzer.retry(result)) {
                test.info("Retrying Test " + methodName);
                totalTestCasesFailed--;
                return;
            }
        }

        test.fail(result.getThrowable());
        test.fail("Script " + methodName + " Failed Running"); 

        // Check if the app was closed unexpectedly
        if (result.getThrowable().toString().contains("NoSuchSessionException")) {
            test.info("Retrying Test " + methodName + " due to app closure");
            totalTestCasesFailed--;
            return;
        }

        totalTestCasesFailed++;
        failedTestCases += "- [FAILED] "+ methodName + " Failed Running\n";

        try {
            android = (AndroidDriver) result.getTestClass().getRealClass().getField("android").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        // Capture screenshot and attach to report
        try {
            String screenshotPath = getScreenshotPath(result.getMethod().getMethodName(), android);
            test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @Override        
    public void onFinish(ITestContext result) {                 
        sendTestSuitesName(testSuitesName);
        sendSummaryTestCases(totalTestCases, totalTestCases - totalTestCasesFailed - totalTestCasesSkipped, totalTestCasesFailed, totalTestCasesSkipped);
        
        if(totalTestCasesFailed>0){
            sendListFailedTestCases(failedTestCases);
        }
        if(totalTestCasesSkipped>0){
            sendListSkippedTestCases(skippedTestCases);
        }
        if(totalTestCasesFailed==0 && totalTestCasesSkipped==0){
            sendCustomMessage("All Test Cases are Passed and Successfully Executed");
        }               
        
        sendCcMessage();
        test.info("Script onFinish method " + result.getName());
        extent.flush();
    }            
    
    public String getScreenshotPath(String methodName, AndroidDriver android) throws IOException {
        File source = android.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "/reports/screenshots/" + methodName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

    @Override        
    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        totalTestCasesSkipped++;
        test.info("Script " + methodName + " Skipped");    
        test.log(Status.SKIP, "Test Skipped");
        skippedTestCases += "- [SKIPPED] "+ methodName + " Skipped\n";
    }               

}
