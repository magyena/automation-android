package id.visionplus.v2.TestCase.Visitor.Register;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_Get_OTP;
import id.visionplus.v2.TestCase.General.TC_Logout;
import id.visionplus.v2.TestCase.Visitor.Login.TC_Login_As_Free_User_Phone;

public class TC_Integrate_Register extends BaseTest {

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	TC_Get_OTP get_otp = new TC_Get_OTP();
	String phone_number = epoch_random();
	String prev_otp = "";
	String new_pass = "Lupa4321";

	public String epoch_random() {
		long epochTime = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
		String formattedTime = dateFormat.format(new Date(epochTime));
		String result = "8990000" + formattedTime.substring(0, Math.max(0, 9 - "899".length()));
		return result;
	}

	@Test(priority = 1)
	public void TC_user_input_valid_phone_number_and_password() throws InterruptedException, TimeoutException {
		click.clickRegister();
		test.pass("Successfully Clicked Register Button");
		Thread.sleep(3000);
		assertion.assertRegisterLoginPage();
		test.pass("Successfully Assert Register Page");

		input.inputPhoneNumber(phone_number);
		test.pass("Successfully Input Text Field with Valid Phone Number");

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");

		System.out.println(phone_number);

		Thread.sleep(3000);
		input.inputPassword("4321Lupa");
		test.pass("Successfully Input Text Field Password with Valid Password");
	}

	@Test(priority = 2, dependsOnMethods = "TC_user_input_valid_phone_number_and_password")
	public void TC_user_click_send_otp_2nd_time() throws InterruptedException, IOException {
		click.clickSendOTP();
		test.pass("Successfully Clicked Send OTP");

	}

	@Test(priority = 3, dependsOnMethods = "TC_user_click_send_otp_2nd_time")
	public void TC_user_input_correct_otp() throws InterruptedException, IOException {
		input.clearOTP();
		test.pass("Successfully Clear Text Field OTP");

		click.clickOtpFld();
		test.pass("Successfully Click Text Field OTP");
		System.out.println("Done Click OTP Field");

		// Get OTP from DB
		String res_otp = get_otp.get_OTP(phone_number);
		input.inputOTP(res_otp);
		test.pass("Successfully Input Text Field OTP with Valid Numbers");
		System.out.println("Done Input OTP");

		Thread.sleep(3000);

		android.hideKeyboard();

		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Send Register Submit Button");

		Thread.sleep(3000);

		System.out.println("Done Register");

		assertion.assertDiscoverText();
		test.pass("Successfully Assert Discover Profile Text After Login");

		click.clickSkip();
		test.pass("Successfully Click Skip Button");

		click.clickContinue();
		test.pass("Successfully Click Continue Button");

		assertion.assertArriveHomePage();
		test.pass("Successfully Assert Arrived at Homepage");
	}
}
