package id.visionplus.v2.TestCase.General;

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
import id.visionplus.v2.TestCase.Free.TC_Integrate_Register;

public class TC_Cluster_Watchlist extends BaseTest {
	TC_Integrate_Register register = new TC_Integrate_Register();
	Click click = new Click();
	Assertion assertion = new Assertion();
	Tap tap = new Tap();
	String testCaseType = System.getProperty("testCaseType");
	// String testCaseType = "FREE";
	Swipe swipe = new Swipe(android);

	@Test(priority = 1)
	public void TC_User_add_32_VOD_to_Cluster_Watchlist() throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		open_app.Choose_Login_As(testCaseType);
		click.clickViewAll();
		test.pass("Sucessfully clicked view All");

		assertion.assertTxtViewAll();
		test.pass("Successfully assert view All");

		Scroll scroll = new Scroll(android);
		By locator = By.xpath(
				"//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/stripTitle\" and @text=\"Love Stories\"]");
		scroll.scrollUntilElementFound(locator);

		click.clickVODComingSoon3();
		click.clickSaveToWatchlist();
		click.clickBack();
		click.clickVODComingSoon2();
		click.clickSaveToWatchlist();
		click.clickBack();
		click.clickVODComingSoon1();
		click.clickSaveToWatchlist();
		click.clickBack();

		By locator1 = By.xpath(
				"//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/stripTitle\" and @text=\"Horror/Thriller\"]");
		scroll.scrollUntilElementFound(locator1);
		click.clickVODSinners();
		click.clickSaveToWatchlist();
		click.clickBack();

		scroll.scrollUntilElementFound(locator1);
		click.clickVODRadio();
		click.clickSaveToWatchlist();
		click.clickBack();
		scroll.scrollUntilElementFound(locator1);
		click.clickVOD12Hari();
		click.clickSaveToWatchlist();
		click.clickBack();
		scroll.scrollUntilElementFound(locator1);
		click.clickVODPrince();
		click.clickSaveToWatchlist();
		click.clickBack();
		scroll.scrollUntilElementFound(locator1);
		click.clickVODPiknik();
		click.clickSaveToWatchlist();
		click.clickBack();
		scroll.scrollUntilElementFound(locator1);
		click.clickVODKatanya();
		click.clickSaveToWatchlist();
		click.clickBack();
		scroll.scrollUntilElementFound(locator1);
		click.clickVODadaDewa();
		click.clickSaveToWatchlist();
		click.clickBack();
		scroll.scrollUntilElementFound(locator1);
		click.clickVODCatatanAkhirSekolah();
		click.clickSaveToWatchlist();
		click.clickBack();
		scroll.scrollUntilElementFound(locator1);
		click.clickVODComic();
		click.clickSaveToWatchlist();
		click.clickBack();

		click.pressBack();
		By locator2 = By.xpath(
				"//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/stripTitle\" and @text=\"Watchlist\"]");
		scroll.scrollUntilElementFound(locator2);

		Swipe swipe = new Swipe(android);
		Point start1 = new Point(941, 1399);
		Point end1 = new Point(185, 1391);
		swipe.swipetoLeft(start1, end1);
		test.pass("Successfully Swipe ");
		swipe.swipetoLeft(start1, end1);
		swipe.swipetoLeft(start1, end1);
		swipe.swipetoLeft(start1, end1);

		Thread.sleep(5000);

	}

}
