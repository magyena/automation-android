package id.visionplus.v2.TestCase.General;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.Visitor.Login.TC_Login_As_Free_User_Phone;
import id.visionplus.v2.TestCase.Visitor.Login.TC_Login_Email;

public class TC_Forgot_Password extends BaseTest{
	
	Click click = new Click();
	Assertion assertion = new Assertion();	
	Input input = new Input();
	TC_Get_OTP get_otp= new TC_Get_OTP();
	
	@Test(priority = 1)
	public void TC_Access_Forgot_Password()throws InterruptedException, IOException, TimeoutException{		
		TC_Login_As_Free_User_Phone login_as_free_phone = new TC_Login_As_Free_User_Phone();
		login_as_free_phone.TC_Access_to_Login_Page();
		
		click.clickForgotPassword();
		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void TC_Forgot_Password_Invalid_Password(String phone_number)throws InterruptedException, IOException, TimeoutException{
		click.clickPhoneNumberFieldForgot();
		test.pass("Successfully Clicked Text Field Phone Number");
		
		input.inputPhoneNumberForgot(phone_number);
		test.pass("Successfully Input Text Field with Valid Phone Number");
		
		System.out.println("Phone Number in Forgot: "+phone_number);

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		input.inputPassword("lupa4321");
		test.pass("Successfully Input Text Field Password with Valid Password");
		
		Thread.sleep(3000);
		assertion.assertTextWarningPasswordPhone();
		test.pass("Successfully Assert Text Warning Password is Displayed");
	}
	
	@Test(priority = 3)
	public void TC_Forgot_Password_OTP_First_Time(String new_pass)throws InterruptedException, IOException, TimeoutException{
		Thread.sleep(3000);
		
		input.clearPasswordField();

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		input.inputPassword(new_pass);
		test.pass("Successfully Input Text Field Password with Valid Password");
		
		click.clickSendOTP();
		test.pass("Successfully Clicked Send OTP");
		
		assertion.assertTimer2Minutes();

	}
	
	@Test(priority = 4)
	public void TC_Forgot_Password_Wrong_OTP()throws InterruptedException, IOException, TimeoutException{
		Thread.sleep(10000);
		
		click.clickOtpFld();
		test.pass("Successfully Click Text Field OTP");

		input.inputOTP("1234");
		test.pass("Successfully Input Text Field OTP with Invalid Numbers");
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Register Submit Button");
		
		assertion.assertTextWarningOTPWrong();
		test.pass("Successfully Assert Text Warning OTP is Displayed");
	}
	
	@Test(priority = 5)
	public void TC_Forgot_Password_Valid_OTP(String phone_number)throws InterruptedException, IOException, TimeoutException{
		input.clearOTP();
		
		click.clickOtpFld();
		test.pass("Successfully Click Text Field OTP");

		//Get OTP from DB
		String otp_forgot = get_otp.get_OTP(phone_number);
		
		input.inputOTP(otp_forgot);
		test.pass("Successfully Input Text Field OTP with Valid Numbers");
		System.out.println("Done Input OTP");
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Register Submit Button");
	}
}
