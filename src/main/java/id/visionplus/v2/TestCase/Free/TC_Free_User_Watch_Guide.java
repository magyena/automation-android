package id.visionplus.v2.TestCase.Free;

import java.awt.Point;
import java.io.IOException;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Swipe;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_OpenApp;
import java.awt.Point;

public class TC_Free_User_Watch_Guide extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();
	String testCaseType = System.getProperty("testCaseType");
	//String testCaseType = "FREE";

	@Test

	public void TC_Free_user_Cant_Watching_Guide() throws IOException, InterruptedException, TimeoutException {
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

		Point start = new Point(800, 1186);
		Point end = new Point(1017, 1186);
		Swipe swipe = new Swipe(android);
		swipe.swipetoLeft(start, end);
		test.pass("Successfully Swipe First");
		Thread.sleep(2000);
		Point start1 = new Point(366, 1154);
		Point end1 = new Point(1017, 1158);
		Swipe swipe1 = new Swipe(android);
		swipe1.swipetoLeft(start1, end1);
		test.pass("Successfully Swipe Second ");
		assertion.assertDisableGuide();
		Point start2 = new Point(366, 1150);
		Point end2 = new Point(1041, 1146);
		Swipe swipe2 = new Swipe(android);
		swipe2.swipetoLeft(start2, end2);
		test.pass("Successfully Swipe Second ");
		assertion.assertDisableGuide();
		Thread.sleep(5000);

	}

	
}
