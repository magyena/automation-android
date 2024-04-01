package id.visionplus.v2.TestCase.Free;

/* Author		: Michael Liong
 * Created Date	: 21 Maret 2024
 * Updated by	: -
 * Updated Date	: -
 * Summary		: TC_Free_User_Watch_VOD
 * 1. Add Comment
 * */

import static org.testng.Assert.fail;

import java.awt.Point;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.Action.Swipe;
import id.visionplus.v2.Action.Tap;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_Homepage;

public class TC_Free_User_Watch_VOD extends BaseTest {

// Simplify Free User FLow
	
	Click click = new Click();
	Assertion assertion = new Assertion();
	Tap tap = new Tap();

	@Test
	public void TC_Free_User_Watch_Free_VOD() throws IOException, InterruptedException, TimeoutException {
		TC_Homepage tc_homePage = new TC_Homepage();
		tc_homePage.TC_Access_VOD_Detail();

		click.clickEps1VOD();
		test.pass("Successfully Clicked Episode 1 Button");

		Thread.sleep(2000);

		click.clickWatchVOD();
		test.pass("Successfully Clicked Watch Button");

		Thread.sleep(10000);

		click.pressBack();
		test.pass("Successfully Press Back to VOD Details Page");
	}

	@Test(dependsOnMethods = "TC_Free_User_Watch_Free_VOD")
	public void TC_Free_User_Cannot_Watch_Premium_VOD_Series()
			throws IOException, InterruptedException, TimeoutException {
		click.pressBack();
		test.pass("Successfully Press Back to VOD Details Page");
		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//android.view.View[starts-with(@content-desc,'E7')]");
		scroll.scrollUntilElementFound(locator);
		test.pass("Successfully Scroll Down Until VOD EP 7 Appear");

		click.clickEps7VOD();
		test.pass("Successfully Clicked Episode 7 Button");

		Thread.sleep(2000);

		assertion.assertVODIsNotPlayable();
		test.pass("Successfully Assert VOD Episode 5 is Not Playable and Need to Subscribe");
	}

	@Test(dependsOnMethods = "TC_Free_User_Cannot_Watch_Premium_VOD_Series")
	public void TC_Free_User_Access_Subscribe_From_VOD() throws IOException, InterruptedException, TimeoutException {
		click.clickSubscribe();
		test.pass("Successfully Clicked Subscribe Button");

		assertion.assertPopUpPackages();
		test.pass("Successfully Assert Pop Up Packages");

		click.pressBack();
		test.pass("Successfully Press Back Button");
	}

	@Test(dependsOnMethods = "TC_Free_User_Access_Subscribe_From_VOD")
	public void TC_User_Slide_List_Cluster() throws IOException, InterruptedException, TimeoutException {
		click.pressBack();
		click.clickBack();
		test.pass("Successfully click Back Button to home");

		Point start = new Point(1009, 1636);
		Point end = new Point(109, 1628);
		Swipe swipe = new Swipe(android);
		swipe.swipetoLeft(start, end);
		test.pass("Succesfully swipe cluster");

		Point start1 = new Point(1009, 1636);
		Point end1 = new Point(109, 1628);
		Swipe swipe1 = new Swipe(android);
		swipe1.swipetoLeft(start1, end1);
		test.pass("Succesfully swipe cluster");

		Thread.sleep(5000);
	}

}
