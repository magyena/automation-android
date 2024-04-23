package id.visionplus.v2.TestCase.General;
/* Author		: Fatah Alim
 * Created Date	: 2 April 2024
 * Updated by	: -
 * Updated Date	: -
 * Summary		: TC_Change_Password
 * 1. Update Scenario Change Password
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
import id.visionplus.v2.TestCase.Free.TC_Integrate_Register;
import id.visionplus.v2.TestCase.Free.TC_Integrate_Register_Email;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Register_With_Email;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Register_With_Phone_Number;
import io.appium.java_client.android.Activity;

public class TC_Manage_Devices extends BaseTest {  //ON HOLD BECAUSE ANY ISSUE IN FE
 
	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
//	String testCaseType = System.getProperty("testCaseType");
	String testCaseType = "PREMIUM_SPORT";
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
	
	@Test(priority = 2)

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
		
		click.clickSettingsAccountNumberorEmail();
		test.pass("Successfully clicked acccount number or email");

		click.clickLogout();
		Thread.sleep(2000);
		android.closeApp();
		
	}
	

}