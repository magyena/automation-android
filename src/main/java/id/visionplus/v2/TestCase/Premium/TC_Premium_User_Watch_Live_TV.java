package id.visionplus.v2.TestCase.Premium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.Action.Scroll;
//import id.visionplus.v2.Action.Tap;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_OpenApp;
import id.visionplus.v2.TestCase.General.TC_Settings;

public class TC_Premium_User_Watch_Live_TV extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
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
        
		
		click.clickPremiumLinear();
		test.pass("Successfully Clicked Premium Linear");
		assertion.assertLiveTVPlayed();
		test.pass("Successfully Asser Premium Live TV Played");
		
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

}