package org.visionplus_android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;  
import java.util.Calendar;  
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.visionplus_android.assertion.AssertPage;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.LoginPageVisionPlus;
import org.visionplus_android.pageObjects.android.MenuFooterPage;
import org.visionplus_android.pageObjects.android.MenuHeaderPage;
import org.visionplus_android.pageObjects.android.TvKUPageVisionPlus;
import org.visionplus_android.pageObjects.android.VODPage;
import org.visionplus_android.pageObjects.android.VplusOriPage;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class Register extends BaseTest
{
	@Test(priority = 1)	
	public void register() throws InterruptedException
	{
		try
		{
			HomePageVisionPlus homepage = new HomePageVisionPlus(android);
			LoginPageVisionPlus loginPageVisionPlus = new LoginPageVisionPlus(android);
			
			
			homepage.lewatiButton();
			test.pass("User berhasil Klik skip button");
			Thread.sleep(3000);
			
			homepage.clickBtnShowcaseTvConnect();
			test.pass("sukses lewati button showcase");
			
			homepage.clickBtnShowcaseOk();
			test.pass("sukses lewati button showcase");
			
			homepage.clickButtonSignin();
			
            Long currentTimestamp = Instant.now().getEpochSecond();
				
			String prefix = "0800"+currentTimestamp;
			 
		    
			
			loginPageVisionPlus.inputPhoneNumber(prefix);
			
			loginPageVisionPlus.clickButtonContinue();
			
			loginPageVisionPlus.inputPhonePassword("4321lupa");
			
			loginPageVisionPlus.clickButtonContinue();
			
			Process p = Runtime.getRuntime().exec("./src/main/java/org/visionplus_android/utils/connectSMSGatewayDB.sh"+" "+ prefix.substring(1));
			p.waitFor();
	
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
	
	
			String otp;
			while ((otp = reader.readLine()) != null) 
			{
			    System.out.println(otp);
			    char charOtp1 = otp.charAt(0);			  
					
				char charOtp2 = otp.charAt(1);
			
				char charOtp3 = otp.charAt(2);
									
				char charOtp4 = otp.charAt(3);
					
				loginPageVisionPlus.inputOtp1(String.valueOf(charOtp1));
				loginPageVisionPlus.inputOtp2(String.valueOf(charOtp2));
				loginPageVisionPlus.inputOtp3(String.valueOf(charOtp3));
				loginPageVisionPlus.inputOtp4(String.valueOf(charOtp4));
			}
			
			
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
			
		
		
		
	}
	

}
