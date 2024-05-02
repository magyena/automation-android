package id.visionplus.v2.TestCase.General;
/* Author		: Fatah Alim
 * Created Date	: 2 April 2024
 * Updated by	: -
 * Updated Date	: -
 * Summary		: TC_Manage_Devices
 * 1. Update Scenario Manage Devices
 * */


import java.awt.Point;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.Action.Swipe;
import id.visionplus.v2.Action.Tap;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Integrate_Register_Email;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Integrate_Register;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Register_With_Email;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Register_With_Phone_Number;
import io.appium.java_client.android.Activity;

public class TC_Manage_Devices extends BaseTest { 

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	String testCaseType = System.getProperty("testCaseType");
//	String testCaseType = "PREMIUM_SPORT";
	BaseTest base = new BaseTest();
	TC_Integrate_Register_Email register = new TC_Integrate_Register_Email();

	@Test(priority = 1)

	public void TC_user_can_show_all_connected_devices() throws InterruptedException, IOException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		open_app.Choose_Login_As(testCaseType);

		click.clickMenuButton();
		test.pass("Successfully clicked menu");

		assertion.assertMenu();
		test.pass("Successfully assert menu");

		click.clickSettingsButton();
		test.pass("Successfully clicked Settings Button");

		assertion.assertSettingsPage();
		test.pass("Successfully assert menu buy package");

		click.clickManageDevices();
		test.pass("Successfully clicked managed devices");

		assertion.assertConnectedDevices();
		test.pass("Successfully assert connected devices");

		click.clickSettingsBackButton();

		click.clickSettingsAccountNumberorEmail();
		test.pass("Successfully clicked acccount number or email");

		click.clickLogout();
		Thread.sleep(2000);
		android.closeApp();

	}

	@Test(priority = 2, dependsOnMethods = "TC_user_can_show_all_connected_devices")

	public void TC_user_can_show_no_connected_devives() throws InterruptedException, IOException, TimeoutException {
		TC_Integrate_Register register = new TC_Integrate_Register();
		base.ConfigureAppium();
		register.TC_user_input_valid_phone_number_and_password();
		register.TC_user_click_send_otp_2nd_time();
		register.TC_user_input_correct_otp();
		
		
		click.clickMenuButton();
		test.pass("Successfully clicked menu");

		assertion.assertMenu();
		test.pass("Successfully assert menu");
		
		click.clickSettingsButton();
		test.pass("Successfully clicked Settings Button");

		assertion.assertSettingsPage();
		test.pass("Successfully assert menu buy package");

		click.clickManageDevices();
		test.pass("Successfully clicked managed devices");

		assertion.assertNoConnectedDevices();
		test.pass("Successfully assert connected devices");
		click.clickSettingsBackButton();
		click.clickSettingsBackButton();
	}

	@Test(priority = 3,dependsOnMethods = "TC_user_can_show_no_connected_devives")

	public void TC_user_can_delete_Devices() throws InterruptedException, IOException, TimeoutException {

		click.clickMenuButton();
		test.pass("Successfully clicked menu");
		click.clickLiveTv();
		Thread.sleep(30000);

		click.clickMenuButton();
		test.pass("Successfully clicked menu");

		click.clickSettingsButton();
		test.pass("Successfully clicked Settings Button");

		assertion.assertSettingsPage();
		test.pass("Successfully assert menu buy package");

		click.clickManageDevices();
		test.pass("Successfully clicked managed devices");

		click.clickListDevices();
		test.pass("Successfully clicked list devices");
		
		click.clickDisconnectDevices();
		test.pass("Successfully clicked disconnect devices");
		
		click.clickConfirmDisconnectDevices();
		test.pass("Succesfully clicked confirm disconnected devices");

		assertion.assertNoConnectedDevices();

		click.clickSettingsBackButton();

		click.clickSettingsAccountNumberorEmail();
		test.pass("Successfully clicked acccount number or email");

		click.clickLogout();
		Thread.sleep(2000);

	}
}
