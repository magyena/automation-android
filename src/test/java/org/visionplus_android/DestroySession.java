package org.visionplus_android;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.visionplus_android.utils.Report;

import com.aventstack.extentreports.ExtentReports;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class DestroySession extends BaseTest
{
	
	@AfterClass
	public void tearDown() {
		try
		{
			extent.flush();
			android.quit();
			service.stop();
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
