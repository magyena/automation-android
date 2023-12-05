package id.visionplus.TestUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import id.visionplus.BaseTest;
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

    @Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub				
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Script onStart method " + result.getName());
        totalTestCases++;
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
        //Concat the Failed Test Case Name and store into one String Variable
        failedTestCaseLists.add("- " + methodName + " Failed Running\n");
//        sendTotalTestCasesFailed(methodName + " Failed Running");
        
        try {
        	android = (AndroidDriver) result.getTestClass().getRealClass().getField("android").get(result.getInstance());
        } catch (Exception e1) {
        	e1.printStackTrace();
        }
        try {
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),android), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }	
    
	    @Override		
	    public void onFinish(ITestContext result) {					
	        // TODO Auto-generated method stub		
	    	sendTotalTestCases(totalTestCases);
	    	sendTotalTestCasesFailed(totalTestCasesFailed);
	    	
	    	 for (String item : failedTestCaseLists) {
	             System.out.println(item);
	             resultString = String.join("\n", item);
	         }
	    	 
	        //Send all the concatenate results of Test Case Name in FailedTestCaseList variable
	    	sendTestCasesFailed(resultString);
	    	
	    	sendCcMessage();
	    	test.info("Script onFinish method " + result.getName());
	        extent.flush();
	    }		

	    @Override		
	    public void onStart(ITestContext result) {	
	    }		

	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
	        test.info("Test failed but it is in defined success ratio " + result.getMethod().getMethodName());
	        		
	    }			

	    @Override		
	    public void onTestSkipped(ITestResult result) {					
	        test.info("Script " + result.getMethod().getMethodName() + " Skipped");	
	        test.log(Status.SKIP, "Test Skipped");
	    }				
	
}
