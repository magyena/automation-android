package id.visionplus.v2.TestCase.General;
/* Author		: Fatah Alim
 * Created Date	: 2 April 2024
 * Updated by	: -
 * Updated Date	: 2 Mei 2024
 * Summary		: TC_Change_Password
 * 1. Delete Fitur Buy again from Transaction History
 * */
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import id.visionplus.v2.PageObjects.TransactionHistoryPage;
import id.visionplus.v2.PageObjects.VODDetailPage;
import id.visionplus.v2.PageObjects.VPlusOriginalsPage;
import expectj.TimeoutException;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.Action.Tap;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_OpenApp;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class TC_Transaction_History extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	Tap tap = new Tap();
	TC_Settings settings = new TC_Settings();
	String testCaseType = System.getProperty("testCaseType");
//	String testCaseType = "PREMIUM_SPORT";

	@Test(priority = 1)

	public void TC_User_see_All_Transactions() throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		open_app.Choose_Login_As(testCaseType);

		click.clickMenuButton();
		test.pass("Successfully Clicked Menu Button");

		Thread.sleep(2000);

		click.clickSettingsButton();
		test.pass("Successfully Clicked Settings Button");

		Thread.sleep(2000);
		click.clickTransactionHistory();
		test.pass("Successfully clicked Transactions History");
		assertion.assertTransactionHistory();
		test.pass("Successfully Clicked Transaction History");
		Thread.sleep(5000);
		Scroll scroll = new Scroll(android);
		By locator = By.xpath(
				"(//android.widget.Button[@text=\"Premium 30 Days 12 Januari 2024 | 01:11 Total Payment Rp 20.000 Payment Status FAILED\"])[1]");
		scroll.scrollUntilElementFound(locator);
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void TC_User_see_success_Transactions() throws IOException, InterruptedException, TimeoutException {

		Thread.sleep(2000);
		click.clickfilterSuccessTransactionHistory();
		test.pass("Successfully Clicked Success Transactions");
		Thread.sleep(5000);
		Scroll scroll = new Scroll(android);
		By locator = By.xpath(
				"//android.widget.Button[@text=\"Premium + Sports 30 Days 23 November 2022 | 16:21 Total Payment Rp 35.000 Payment Status SUCCESS\"]");
		scroll.scrollUntilElementFound(locator);
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void TC_User_see_Failed_Transactions() throws IOException, InterruptedException, TimeoutException {

		Thread.sleep(2000);
		click.clickfilterFailedTransactionHistory();
		test.pass("Successfully Clicked Failed Transactions");
		Thread.sleep(5000);
		Scroll scroll = new Scroll(android);
		By locator = By.xpath(
				"(//android.widget.Button[@text=\"Premium 30 Days 31 Desember 2023 | 19:08 Total Payment Rp 20.000 Payment Status FAILED\"])[1]");
		scroll.scrollUntilElementFound(locator);

		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void TC_User_see_Pending_Transactions() throws IOException, InterruptedException, TimeoutException {

		Thread.sleep(2000);
		click.clickfilterPendingTransactionHistory();
		test.pass("Successfully Clicked Pending Transactions");
		Thread.sleep(2000);
		click.clickCloseToSettings();
		test.pass("Successfully Clicked Close Help Center Page");

	}

	@Test(priority = 5)
	public void TC_User_See_Help_Center() throws IOException, InterruptedException, TimeoutException {
		Thread.sleep(2000);
		click.clickTransactionHistory();
		test.pass("Successfully clicked Transactions History");
		assertion.assertTransactionHistory();
		test.pass("Successfully Clicked Transaction History");
		Thread.sleep(5000);
		click.clickfilterSuccessTransactionHistory();
		test.pass("Successfully Clicked Success Transactions");
		Thread.sleep(2000);
		tap.tap(981, 667);
		tap.tap(145, 2211);
		
		Thread.sleep(5000);
		assertion.assertHelpCentre();
		Thread.sleep(2000);	
		click.clickCloseToSettings();
		test.pass("Successfully Clicked Close Help Center Page");

	}
}