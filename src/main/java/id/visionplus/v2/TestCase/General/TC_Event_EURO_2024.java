package id.visionplus.v2.TestCase.General;

import static org.testng.Assert.assertTrue;

import java.awt.Point;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.Action.Swipe;
import id.visionplus.v2.Action.Tap;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Integrate_Register;

public class TC_Event_EURO_2024 extends BaseTest {
	Click click = new Click();
	Assertion assertion = new Assertion();
	BaseTest base = new BaseTest();
	Tap tap = new Tap();

	@Test(priority = 1)
	public void TC_Euro_Package_on_Buy_Package() throws InterruptedException, IOException, TimeoutException {
		TC_Integrate_Register register = new TC_Integrate_Register();
		register.TC_user_input_valid_phone_number_and_password();
		register.TC_user_click_send_otp_2nd_time();
		register.TC_user_input_correct_otp();

		click.clickMenuButton();
		test.pass("Successfully clicked menu button");

		click.clickMyPackage();
		test.pass("Succesfully clicked buy package");

		assertion.assertEventEuroPackage();
		test.pass("Successfully assert euro package");

		Thread.sleep(2000);
	}

	@Test(priority = 2, dependsOnMethods = "TC_Euro_Package_on_Buy_Package")
	public void TC_Redeem_Voucher() throws InterruptedException, IOException, TimeoutException {
		TC_Redeem_Voucher voucher = new TC_Redeem_Voucher();

		click.clickMenuButton();
		test.pass("Successfully clicked menu button");

		click.clickSettingsButton();

		voucher.TC_Access_Voucher();
		voucher.TC_User_input_Success_Voucher();

	}

	@Test(priority = 3, dependsOnMethods = "TC_Euro_Package_on_Buy_Package")
	public void TC_Euro_Package_On_My_Package_After_Redeem()
			throws InterruptedException, IOException, TimeoutException {
		click.pressBack();

		click.clickTransactionHistory();

		assertion.assertTransactionHistoryEuroPackage();

		click.clickCloseSettings();

		click.clickSettingsBackButton();

	}

	@Test(priority = 4, dependsOnMethods = "TC_Euro_Package_On_My_Package_After_Redeem")
	public void TC_Euro_package_entitlement() throws InterruptedException, IOException, TimeoutException {

		click.clickMenuButton();

		click.clickMyPackage();

		assertion.assertCurrentEuroPackage();
	}

	@Test(priority = 5, dependsOnMethods = "TC_Euro_package_entitlement")
	public void TC_Play_Channel_Euro_1_and_Euro_2() throws InterruptedException, IOException, TimeoutException {
		click.clickMenuButton();

		click.clickLiveTv();
		Point start = new Point(535, 2199);
		Point end = new Point(551, 901);
		Swipe swipe = new Swipe(android);
		for (int i = 0; i < 16; i++) {
			swipe.swipetoLeft(start, end);

		}

		assertion.assertEuroChannel();

		click.clickEuroChannel1();
		Thread.sleep(5000);

		click.clickEuroChannel2();
		Thread.sleep(5000);
		assertion.assertSubscribe();

	}

	@Test(priority = 6, dependsOnMethods = "TC_Play_Channel_Euro_1_and_Euro_2")
	public void TC_Euro_Package_Play_VOD() throws InterruptedException, IOException, TimeoutException {

		click.clickMenuButton();

		click.clickMenuHome();

		click.clickFirstContentClusterVPlusOriginals();

		click.clickWatchVOD();

		Thread.sleep(5000);

		click.pressBack();
		click.pressBack();
	}

	@Test(priority = 7,dependsOnMethods = "TC_Euro_Package_Play_VOD")
	public void TC_Euro_Package_Play_LiveTV_Premium() throws InterruptedException, IOException, TimeoutException {

		click.clickMenuButton();

		click.clickLiveTv();
		Point start = new Point(555,1029);
		Point end = new Point(555,2014);
		Swipe swipe = new Swipe(android);
		for (int i=0;i<20;i++)
		{
			swipe.swipetoLeft(start, end);
			
		}
		click.clickPremiumLinear();
		assertion.assertSubscribe();

		Thread.sleep(5000);

		android.closeApp();
	}

	@Test(priority = 8,dependsOnMethods = "TC_Euro_Package_Play_LiveTV_Premium")
	public void TC_Free_User_Watch_Channel_Euro() throws InterruptedException, IOException, TimeoutException {
		base.ConfigureAppium();
		TC_OpenApp open = new TC_OpenApp();
		open.TC_Open_App_as_Free_User();
		click.clickMenuButton();

		click.clickLiveTv();
		Point start = new Point(535, 2199);
		Point end = new Point(551, 901);
		Swipe swipe = new Swipe(android);
		for (int i = 0; i < 16; i++) {
			swipe.swipetoLeft(start, end);

		}

		assertion.assertEuroChannel();

		click.clickEuroChannel1();
		Thread.sleep(5000);

		assertion.assertSubscribetoPremiumSport();

		android.closeApp();
		System.out.println("Close App using Free User");
	}

	@Test(priority = 9, dependsOnMethods = "TC_Free_User_Watch_Channel_Euro")
	public void TC_Premium_User_Watch_Channel_Euro() throws InterruptedException, IOException, TimeoutException {
		base.ConfigureAppium();
		TC_OpenApp open = new TC_OpenApp();
		open.TC_Open_app_as_Premium_User();

		click.clickMenuButton();
		click.clickLiveTv();
		Point start = new Point(535, 2199);
		Point end = new Point(551, 901);
		Swipe swipe = new Swipe(android);
		for (int i = 0; i < 16; i++) {
			swipe.swipetoLeft(start, end);

		}

		assertion.assertEuroChannel();

		click.clickEuroChannel1();
		Thread.sleep(5000);

		assertion.assertSubscribetoPremiumSport();

		android.closeApp();
		System.out.println("Close App using Premium User");
	}
}
