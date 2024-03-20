package id.visionplus.v2.TestCase.PremiumSport;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_Menu;

public class TC_Premium_Sport_User_Watch_Live_TV extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();

	@Test
	public void TC_Premium_Sport_User_Watch_Free_Linear() throws IOException, InterruptedException, TimeoutException {
		TC_Menu tc_Menu = new TC_Menu();
		tc_Menu.TC_Access_Live_Tv();
		test.pass("Successfully Access to RCTI in Live TV Page");

		click.clickFreeLinear();
		test.pass("Successfully Clicked Free Linear Channel");

		Thread.sleep(1000);

		assertion.assertLiveTVPlayed();
		test.pass("Successfully Assert Live TV is Played");
	}

	@Test(priority = 1, dependsOnMethods = "TC_Premium_Sport_User_Watch_Free_Linear")
	public void TC_Premium_Sport_User_Watch_Premium_Linear()
			throws IOException, InterruptedException, TimeoutException {
		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//*[contains(@text,'006')]");
		scroll.scrollUntilElementFound(locator);

		click.clickPremiumLinear();
		test.pass("Successfully Clicked Premium Linear Channel");

		Thread.sleep(1000);

		assertion.assertLiveTVPlayed();
		test.pass("Successfully Assert Live TV is Played");

	}

	@Test(priority = 2, dependsOnMethods = "TC_Premium_Sport_User_Watch_Premium_Linear")
	public void TC_Premium_Sport_User_Watch_Premium_Sport_Linear()
			throws IOException, InterruptedException, TimeoutException {
		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//*[contains(@text,'115')]");
		scroll.scrollUntilElementFound(locator);

		click.clickPremiumSportLinear();
		test.pass("Successfully Clicked Premium Sport Linear Channel");

		Thread.sleep(1000);

		assertion.assertLiveTVPlayed();
		test.pass("Successfully Assert Live TV is Played");

	}
	@Test(priority = 3, dependsOnMethods = "TC_Premium_Sport_User_Watch_Premium_Sport_Linear")
	public void TC_Detail_Channel_Sport() throws IOException, InterruptedException, TimeoutException {
        Scroll scrolll = new Scroll(android);
		By locator = By.xpath("//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/live_tv_channel_list_element_channel_number\" and @text=\"112\"]");
	    scrolll.scrollUntilElementFound(locator);
	    Thread.sleep(2000);
        click.clikDetailChannel();
        Thread.sleep(2000);
        Scroll scroll = new Scroll(android);
	    scroll.scrollDown(0.350);
	    assertion.assertDetailChannelSport();    
	    Thread.sleep(5000);
	    

	}
}
