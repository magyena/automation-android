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

public class TC_Change_Password extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	TC_Get_OTP get_otp = new TC_Get_OTP();
	String phone_number = epoch_random();
	String email = email_random();

	public String epoch_random() {
		long epochTime = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
		String formattedTime = dateFormat.format(new Date(epochTime));
		String result = "899" + formattedTime.substring(0, Math.max(0, 13 - "899".length()));
		return result;
	}

	public String email_random() {
		long epochTime = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		String formattedTime = dateFormat.format(new Date(epochTime));
		String result = "visionplus" + formattedTime.substring(0, Math.max(0, 20 - "visionplus".length()))
				+ "@visionplus.id";
		return result;
	}

//	@Test(priority = 1)
//
//	public void TC_User_Invalid_Current_Password() throws InterruptedException, IOException, TimeoutException {
//		TC_Integrate_Register register = new TC_Integrate_Register();
//
//		register.TC_user_input_valid_phone_number_and_password();
//		register.TC_user_click_send_otp_2nd_time();
//		register.TC_user_input_correct_otp();
//
//		click.clickMenuButton();
//		test.pass("Successfully clicked menu");
//
//		assertion.assertMenu();
//		test.pass("Successfully assert menu");
//
//		click.clickSettingsButton();
//		test.pass("Successfully clicked Settings Button");
//
//		assertion.assertSettingsPage();
//		test.pass("Successfully assert menu buy package");
//
//		click.clickSettingsAccountNumberorEmail();
//		test.pass("Successfully clicked acccount number or email");
//
//		assertion.assertSubscriberNumberSettingsPage();
//		test.pass("Successfully assert subscription number");
//		Thread.sleep(2000);
//
//		click.clickChangePassword();
//		test.pass("Successfully clicked change password");
//		Thread.sleep(2000);
//		assertion.assertChangePasswordWebView();
//		test.pass("Successfully assert change password page");
//		
//		input.inputCurrentPasswordChangePassword("4321aLupa");
//		test.pass("Successfully input current password");
//
//		input.inputNewPasswordChangePassword("4321LupA");
//		test.pass("Successfully input current password");
//		
//		click.clickNextChangePassword();
//		test.pass("Successfully clikced next");
//		
//		assertion.assertChangePassworfailed();
//		test.pass("Successfully assert change password failed");
//		
//		click.clickBtnOKChangePasswordFailed();
//		test.pass("Successfully clicked button ok");
//	}
//
//	@Test(priority = 2)
//
//	public void TC_User_Change_Password_Not_Criteria() throws InterruptedException, IOException, TimeoutException {
//
//		input.ClearCurrentPasswordChangePassword();
//		input.inputCurrentPasswordChangePassword("4321Lupa");
//		test.pass("Successfully input current password");
//		
//		input.ClearNewPasswordChangePassword();
//		
//
//		input.inputNewPasswordChangePassword("4321lupaaa");
//		test.pass("Successfully input current password");
//		
//		assertion.assertPasswordNoCriteria();
//		test.pass("Succesfully assert password no criteria");
//		
//		input.ClearNewPasswordChangePassword();
//		
//		Thread.sleep(2000);
//	}
//
//	@Test(priority = 3)
//
//	public void TC_User_Change_Password_Success() throws InterruptedException, IOException, TimeoutException {
//		
//		input.inputNewPasswordChangePassword("4321LupA");
//		test.pass("Successfully input current password");
//
//		click.clickNextChangePassword();
//		test.pass("Successfully clikced next");
//
//		assertion.assertSuccessChangePassword();
//		test.pass("Successfully assert image success");
//
//		click.clickBtnSuccessBack();
//		test.pass("Successfully clicked button back");
//
//		Thread.sleep(2000);
//		
//		click.clickLogout();
//	}

	@Test(priority = 4)

	public void TC_User_Change_Password_Success_Email() throws InterruptedException, IOException, TimeoutException {
		TC_Integrate_Register_Email register = new TC_Integrate_Register_Email();

		register.TC_access_register_by_email_page();
		register.TC_user_input_valid_email_and_password();
		register.TC_user_input_correct_otp();
		Thread.sleep(5000);
	}
}