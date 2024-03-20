package id.visionplus.v2.TestCase.Premium;

import java.awt.Point;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Swipe;
import id.visionplus.v2.Action.Tap;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_OpenApp;

public class TC_Premium_Sport_Watch_guide extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();
	Tap tap = new Tap();
String testCaseType = System.getProperty("testCaseType");
//	String testCaseType = "PREMIUM_SPORT";

	@Test(priority = 1) // T338

	public void TC_User_Can_Watching_Guide()
			throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		open_app.Choose_Login_As(testCaseType);

		click.clickMenuButton();
		test.pass("Successfully Clicked Menu");
		assertion.assertMenu();
		test.pass("Successfully assert Menu");
		click.clickBtnProgramGuide();
		test.pass("Successfully Clicked Menu Program Guide");
		assertion.assertProgramGuide();
		Thread.sleep(2000);

		click.clickguide3();
		test.pass("Successfully click guide");
		click.clickBtnWatchGuide();
		test.pass("Successfully click button watch");
		Thread.sleep(10000);

	}

}
