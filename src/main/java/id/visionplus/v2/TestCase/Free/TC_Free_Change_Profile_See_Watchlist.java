package id.visionplus.v2.TestCase.Free;

import java.awt.Point;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.Action.Swipe;
import id.visionplus.v2.Action.Tap;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_Profile;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TC_Free_Change_Profile_See_Watchlist extends BaseTest {

	TC_Profile profile = new TC_Profile();
	Click click = new Click();
	Tap tap = new Tap();
	Input input = new Input();
	Assertion assertion = new Assertion();
	Scroll scroll = new Scroll(android);

	public String username_random_15_char() {
		long epochTime = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		String formattedTime = dateFormat.format(new Date(epochTime));
		String result = "Visionplus" + formattedTime.substring(0, Math.max(0, 15 - "visionplus".length()));
		return result;
	}

	String random_name = username_random_15_char();

	@Test(priority = 1)

	public void TC_User_Delete_VOD_Watchlist() throws InterruptedException, IOException, TimeoutException {

		profile.TC_Access_Profile();
		profile.TC_Back_to_Homepage();
		profile.TC_Access_Manage_Profile();
		profile.TC_Delete_Profile();
		click.clickSettingsBackButton();
		click.clickSettingsBackButton();
		click.clickProfileButton();
		profile.TC_Add_Profile();
		profile.TC_Back_to_Homepage();

		Scroll scroll = new Scroll(android);
		By locator1 = By.xpath(
				"//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/stripTitle\" and @text=\"Watchlist\"]");
		scroll.scrollUntilElementFound(locator1);

		click.clickMenuButton();
		click.clickSearchButton();
		input.clearSearch();

		click.clickSearchField();
		test.pass("Successfully Clicked Search Field");

		input.inputSearch("Cinta Di Balik Awan");
		test.pass("Successfully Input Search Field with Valid Keyword");

		click.clickVodCintaDiBalikAwan();
		click.clickAddWatchlist();
		click.pressBack();
		click.pressBack();

	}

	@Test(priority = 2,dependsOnMethods ="TC_User_Delete_VOD_Watchlist")

	public void TC_User_see_Cluster_Watchlist_on_Other_Profile()
			throws InterruptedException, IOException, TimeoutException {
		click.clickProfileButton();
		click.clickLastProfile();
		Swipe swipe = new Swipe(android);
		Point start = new Point(523, 1500);
		Point end = new Point(531, 740);
		swipe.swipetoLeft(start, end);
		test.pass("Successfully Swipe ");
		assertion.assertClusterWatchlist();
		Thread.sleep(5000);

	}

	@Test(priority = 3,dependsOnMethods = "TC_User_see_Cluster_Watchlist_on_Other_Profile")

	public void TC_User_see_Cluster_New_Release() throws InterruptedException, IOException, TimeoutException {

		Point start = new Point(487, 2171);
		Point end = new Point(474, 374);
		for (int i = 0; i < 3; i++) {
			Swipe swipe = new Swipe(android);
			swipe.swipetoLeft(start, end);

		}

		click.clickContentClusterNewRelease();

		assertion.assertContentClusterNewRelease();

		click.pressBack();
		Thread.sleep(5000);
	}

	@Test(priority = 4,dependsOnMethods ="TC_User_see_Cluster_New_Release")

	public void TC_User_Cant_See_LiveTV_in_Cluster_Continue_Watching()
			throws InterruptedException, IOException, TimeoutException {
		click.clickProfileButton();
		click.clickFirstProfile();
		Swipe swipe = new Swipe(android);
		Point start = new Point(487, 2171);
		Point end = new Point(474, 374);
		swipe.swipetoLeft(start, end);

		assertion.assertClusterContinueWatching();

		Point start1 = new Point(965, 1636);
		Point end1 = new Point(137, 1620);

		for (int i = 0; i < 5; i++) {
			Swipe swipe1 = new Swipe(android);
			swipe1.swipetoLeft(start1, end1);

		}
	}
		@Test(priority = 5,dependsOnMethods ="TC_User_Cant_See_LiveTV_in_Cluster_Continue_Watching")

		public void TC_Slide_banner()
				throws InterruptedException, IOException, TimeoutException {

		Scroll scroll =new Scroll(android);
		scroll.scrollUp(0.1);
		
		Point start = new Point(937, 1636);
		Point end = new Point(189, 1628);

		for (int i = 0; i < 3; i++) {
			Swipe swipe1 = new Swipe(android);
			swipe1.swipetoLeft(start, end);
		}
	}
}
