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

public class TC_Premium_Watch_guide extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();
	Tap tap = new Tap();
	String testCaseType = System.getProperty("testCaseType");
//	String testCaseType = "PREMIUM";

	@Test(priority = 1) // T335

	public void TC_User_be_able_to_showing_7_days_after_Guide()
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

		tap.tap(72, 394);
		for (int i = 0; i < 9; i++) {
		    tap.tap(1013, 390);
		}
		Thread.sleep(5000);

	}

	@Test(priority = 2) // T336

	public void TC_User_not_be_able_to_click_7_days_after_Guide()
			throws IOException, InterruptedException, TimeoutException {
		click.clickguide3();
		test.pass("Successfully click guide");
		assertion.assertDetailProgramGuide();
		test.pass("Successfully assert detail program guide");
		Thread.sleep(5000);

	}

	@Test(priority = 3) // T337

	public void TC_User_Can_Watching_Guide() throws IOException, InterruptedException, TimeoutException {

		click.clickbtnBackGuide();
		for (int i = 0; i < 9; i++) {
			tap.tap(72, 398);
		}

		click.clickguide3();
		test.pass("Successfully click guide");
		click.clickBtnWatchGuide();
		test.pass("Successfully click button watch");
		Thread.sleep(10000);
	}
}
