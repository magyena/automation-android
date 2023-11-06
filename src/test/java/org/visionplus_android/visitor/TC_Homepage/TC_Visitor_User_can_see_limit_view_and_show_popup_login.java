package org.visionplus_android.visitor.TC_Homepage;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.LainnyaMenuPage;
import org.visionplus_android.pageObjects.android.VODPage;

import io.appium.java_client.AppiumDriver;

public class TC_Visitor_User_can_see_limit_view_and_show_popup_login extends BaseTest
{
	
	
	@Test
	public void TC_Visitor_User_can_see_limit_view_and_show_popup_login() throws InterruptedException
	{
		try
		{
			HomePageVisionPlus homePageVisionPlus = new HomePageVisionPlus(android);
			VODPage vod = new VODPage(android);
			homePageVisionPlus.lewatiButton();
			test.pass("Sukses lewati button");

			homePageVisionPlus.clickBtnShowcaseTvConnect();
			test.pass("sukses lewati button showcase");
			
			homePageVisionPlus.clickBtnShowcaseOk();
			test.pass("sukses lewati button showcase");

			homePageVisionPlus.lainnyaButton();
			//test.pass("Sukses lewati button");
			
			homePageVisionPlus.clickBtnTVku();
			test.pass("Sukses lewati button TVku");
			
		
			vod.clickBtnFreeLinearAntv();
			
			vod.clickBtnChromeCast();
			test.pass("User berhasil Klik Button Chromecast");
			vod.clickBtnDataSaver();
			test.pass("User berhasil Klik Button Data Saver");
			for (int i = 0; i < 10; i++) 
			{
				Thread.sleep(60000);
				System.out.println("loop");
			}
			vod.assertErrorSubcriptionPremiumLinear();
			
			
		} 
		catch (Exception e) 
		{
			
		}
	
		
		
	}

}
