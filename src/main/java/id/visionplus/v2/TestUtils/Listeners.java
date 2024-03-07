package id.visionplus.v2.TestUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
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
        // TODO Auto-generated method stub				
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Script onStart method " + result.getName());
        totalTestCases++;
        
        System.out.println("Running Test Class: " + result.getTestClass().getName() + ", Method: " + result.getMethod().getMethodName());
        
        // Extract the test suite name from the result's ITestContext
        ITestContext context = result.getTestContext();
        XmlSuite xmlSuite = context.getSuite().getXmlSuite();
        String suiteName = xmlSuite.getName();

        // Log the test suite name
        test.info("Test Suite: " + suiteName);
        testSuitesName=suiteName;
    }	
    
    @Override		
    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub				
        test.log(Status.PASS, "Script " + result.getMethod().getMethodName() + " Successfuly Running");
    }	
    
    @Override		
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub		
    	String methodName = result.getMethod().getMethodName();

	        test.fail(result.getThrowable());
	        test.fail("Script " + result.getMethod().getMethodName() + " Failed Running"); 
	           
	        totalTestCasesFailed++;
	        failedTestCases += "- [FAILED] "+ methodName + " Failed Running\n";

        try {
        	android = (AndroidDriver) result.getTestClass().getRealClass().getField("android").get(result.getInstance());
        } catch (Exception e1) {
        	e1.printStackTrace();
        }
        try {
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),android), result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }	
    
	    @Override		
	    public void onFinish(ITestContext result) {					
	        // TODO Auto-generated method stub	
	    	sendTestSuitesName(testSuitesName);
	    	sendSummaryTestCases(totalTestCases, totalTestCases - totalTestCasesFailed - totalTestCasesSkipped, totalTestCasesFailed, totalTestCasesSkipped);
	    	
	    	if(totalTestCasesFailed>0){
		    	sendListFailedTestCases(failedTestCases);
	    	}
	    	
	    	if(totalTestCasesSkipped>0){
	    		sendListSkippedTestCases(skippedTestCases);
	    	}

	    	if(totalTestCasesFailed==0 && totalTestCasesSkipped==0){
	    		sendCustomMessage("All Test Case are Passed and Successfully Executed");
	    	}
	    	
	    	sendCcMessage();
	    	test.info("Script onFinish method " + result.getName());
	        extent.flush();
	    }			

	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
	        test.info("Test failed but it is in defined success ratio " + result.getMethod().getMethodName());
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
