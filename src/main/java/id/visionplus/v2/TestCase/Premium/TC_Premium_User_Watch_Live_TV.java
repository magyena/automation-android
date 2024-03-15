package id.visionplus.v2.TestCase.Premium;

import java.io.IOException;

<<<<<<< HEAD
import org.openqa.selenium.By;
import org.testng.annotations.Test;

=======
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
>>>>>>> a2faab1 (First Push to New Branch)
import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.Action.Scroll;
<<<<<<< HEAD
//import id.visionplus.v2.Action.Tap;
=======
import id.visionplus.v2.Action.Tap;
import id.visionplus.v2.Action.Toggle;
>>>>>>> a2faab1 (First Push to New Branch)
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_OpenApp;
import id.visionplus.v2.TestCase.General.TC_Settings;

public class TC_Premium_User_Watch_Live_TV extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
<<<<<<< HEAD
//	Tap tap = new Tap();
	TC_Settings settings = new TC_Settings();
//	String testCaseType = System.getProperty("testCaseType");
	String testCaseType = "PREMIUM_USER";

	@Test(priority = 1)

	public void TC_User_Premium_Watch_Prenium_Live_TV_Channel_Premium() throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		open_app.Choose_Login_As(testCaseType);
		
		click.clickMenuButton();
	    test.pass("Successfully Clicked Menu Button");
	    
	    click.clickLiveTv();
	    test.pass("Successfully Clicked Menu Button");
        assertion.assertLiveTVPlayed();	 
        Thread.sleep(2000);
        
		
=======
	Tap tap = new Tap();
	TC_Settings settings = new TC_Settings();
	Toggle toggle = new Toggle();
	String testCaseType = System.getProperty("testCaseType");
//	String testCaseType = "PREMIUM_USER";

	@Test(priority = 1)

	public void TC_User_Premium_Watch_Premium_Live_TV_Channel_Premium()
			throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		open_app.Choose_Login_As(testCaseType);

		click.clickMenuButton();
		test.pass("Successfully Clicked Menu Button");

		click.clickLiveTv();
		test.pass("Successfully Clicked Menu Button");
		assertion.assertLiveTVPlayed();	
		Thread.sleep(2000);
>>>>>>> a2faab1 (First Push to New Branch)
		click.clickPremiumLinear();
		test.pass("Successfully Clicked Premium Linear");
		assertion.assertLiveTVPlayed();
		test.pass("Successfully Asser Premium Live TV Played");
<<<<<<< HEAD
		
	}

//	@Test(priority = 2)
//	public void TC_User_see_success_Transactions() throws IOException, InterruptedException, TimeoutException {
//
//		Thread.sleep(2000);
//		click.clickfilterSuccessTransactionHistory();
//		test.pass("Successfully Clicked Success Transactions");
//		Thread.sleep(5000);
//		Scroll scroll = new Scroll(android);
//		By locator = By.xpath(
//				"//android.widget.Button[@text=\"Premium + Sports 30 Days 23 November 2022 | 16:21 Total Payment Rp 35.000 Payment Status SUCCESS\"]");
//		scroll.scrollUntilElementFound(locator);
//		Thread.sleep(2000);
//	}

=======

	}

	@Test(priority = 2)
	public void TC_User_Premium_Watch_Premium_Live_TV_Channel_Premium_Sports()
			throws IOException, InterruptedException, TimeoutException {

		Thread.sleep(2000);
		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//*[contains(@text,'115')]");
		scroll.scrollUntilElementFound(locator);
		Thread.sleep(2000);
		click.clickPremiumSportLinear();
		test.pass("Successfully Clicked Premium Sports");
		assertion.assertSubscribetoPremiumSport();
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	public void TC_User_See_Live_TV_Channel_Then_Disconnect_internet()
			throws IOException, InterruptedException, TimeoutException {

		Thread.sleep(2000);
		Scroll scroll = new Scroll(android);
		scroll.scrollUpWithParameter(100.0);
		Thread.sleep(2000);
		click.clickInewsTv();
		test.pass("Successfully Clicked Inews TV");
		assertion.assertLiveTVPlayed();
		test.pass("Successfully assert Live Tv");
		Thread.sleep(2000);
		toggle.disable_wifi_connection();		
		test.pass("Succesfully Disable wifi connection");
//		assertion.assertErrorConnection();
//		test.pass("Successfully assert Error Connection");
		Thread.sleep(10000);
		toggle.enable_wifi_connection();
		Thread.sleep(10000);
		
		
	}

>>>>>>> a2faab1 (First Push to New Branch)
}