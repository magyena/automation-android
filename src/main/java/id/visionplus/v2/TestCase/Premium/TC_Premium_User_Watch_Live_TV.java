package id.visionplus.v2.TestCase.Premium;

import java.awt.Point;
import java.io.IOException;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.Action.Swipe;
import id.visionplus.v2.Action.Tap;
import id.visionplus.v2.Action.Toggle;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_OpenApp;
import id.visionplus.v2.TestCase.General.TC_Settings;

public class TC_Premium_User_Watch_Live_TV extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	Tap tap = new Tap();
	TC_Settings settings = new TC_Settings();
	Toggle toggle = new Toggle();
	String testCaseType = System.getProperty("testCaseType");
//	String testCaseType = "PREMIUM";

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
		Thread.sleep(5000);
		click.clickPremiumLinear();
		Thread.sleep(3000);
		test.pass("Successfully Clicked Premium Linear");
		assertion.assertLiveTVNotPlayed();
		test.pass("Successfully Asser Premium Live TV Played");
	}

	@Test(priority = 2, dependsOnMethods = "TC_User_Premium_Watch_Premium_Live_TV_Channel_Premium")
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

	@Test(priority = 3,dependsOnMethods = "TC_User_Premium_Watch_Premium_Live_TV_Channel_Premium_Sports")
	public void TC_User_See_Live_TV_Channel_Then_Disconnect_internet() throws IOException, InterruptedException, TimeoutException {
		Thread.sleep(2000);
		Point start = new Point(555,1029);
		Point end = new Point(555,2014);
		Swipe swipe = new Swipe(android);
		for (int i=0;i<13;i++)
		{
			swipe.swipetoLeft(start, end);
			
		}
		test.pass("Successfully Swipe ");
		
		Thread.sleep(2000);
		click.clickInewsTv();
		test.pass("Successfully Clicked Inews TV");
		assertion.assertLiveTVPlayed();
		test.pass("Successfully assert Live Tv");
		Thread.sleep(2000);
		toggle.disable_wifi_connection();		
		test.pass("Succesfully Disable wifi connection");
		assertion.assertErrorConnection();
		test.pass("Successfully assert Error Connection");
		Thread.sleep(10000);
		toggle.enable_wifi_connection();
		Thread.sleep(10000);
		
	}
	
	@Test(priority = 4,dependsOnMethods = "TC_User_See_Live_TV_Channel_Then_Disconnect_internet")
	public void TC_User_Click_Info_Button() throws IOException, InterruptedException, TimeoutException {
	
		click.clickInfoButtonLiveTV();
		test.pass("Successfully click info button");
	}
}