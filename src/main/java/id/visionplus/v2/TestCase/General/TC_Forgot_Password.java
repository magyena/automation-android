package id.visionplus.v2.TestCase.General;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.Visitor.Login.TC_Login_As_Free_User_Phone;
import id.visionplus.v2.TestCase.Visitor.Login.TC_Login_Email;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Integrate_Register_Email;
import id.visionplus.v2.TestCase.Visitor.Register.TC_Register_With_Email;

public class TC_Forgot_Password extends BaseTest{
	
	Click click = new Click();
	Assertion assertion = new Assertion();	
	Input input = new Input();
	TC_Get_OTP get_otp= new TC_Get_OTP();
	String new_pass = "Lupa4321";
    String registeredEmail;
	
	@Test(priority = 1)
	public void TC_Access_Forgot_Password()throws InterruptedException, IOException, TimeoutException{
		TC_Integrate_Register_Email integrate_register_email = new TC_Integrate_Register_Email();
		TC_Register_With_Email register_with_email = new TC_Register_With_Email();
				
		System.out.println("Done Access Register Page");
		register_with_email.TC_user_input_valid_email_and_password();
		
		System.out.println("Done input email and password");
		registeredEmail=register_with_email.TC_input_otp_with_email();
		
		System.out.println(registeredEmail);
		
		TC_Logout logout = new TC_Logout();
		logout.TC_Access_Settings();
		logout.TC_Access_Logout();
		
		TC_Login_As_Free_User_Phone login_as_free_phone = new TC_Login_As_Free_User_Phone();
		login_as_free_phone.TC_Access_to_Login_Page();
		
		click.clickForgotPassword();
		Thread.sleep(3000);		

		int attempts = 0;
		while (attempts < 5) {
		    try {
				click.clickRegisterLoginByEmailSection();
				test.pass("Successfully Clicked Login by Email Section Button");
		        break;
		    } catch (StaleElementReferenceException e) {
		    	System.out.println(e.getMessage());
		    }
		    attempts++;
		    Thread.sleep(2000);
		}
	}
	
	@Test(priority = 2, dependsOnMethods = "TC_Access_Forgot_Password")
	public void TC_Forgot_Password_Invalid_Password()throws InterruptedException, IOException, TimeoutException{
		
		click.clickEmailFieldForgot();
		test.pass("Successfully Clicked Text Email");
		
		input.inputEmail(registeredEmail);
		test.pass("Successfully Input Text Field with Valid Email");
		
		System.out.println("Email in Forgot: "+registeredEmail);

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		input.inputPassword("lupa4321");
		test.pass("Successfully Input Text Field Password with Invalid Password");
		
		Thread.sleep(3000);
		assertion.assertTextWarningPasswordPhone();
		test.pass("Successfully Assert Text Warning Password is Displayed");
	}
	
	@Test(priority = 3, dependsOnMethods = "TC_Forgot_Password_Invalid_Password")
	public void TC_Forgot_Password_OTP_First_Time()throws InterruptedException, IOException, TimeoutException{
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
	
	@Test(priority = 4, dependsOnMethods = "TC_Forgot_Password_OTP_First_Time")
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
	
	@Test(priority = 5, dependsOnMethods = "TC_Forgot_Password_Wrong_OTP")
	public void TC_Forgot_Password_Valid_OTP()throws InterruptedException, IOException, TimeoutException{
		input.clearOTP();
		
		click.clickOtpFld();
		test.pass("Successfully Click Text Field OTP");

		//Get OTP from DB
		String otp_forgot = get_otp.get_OTP(registeredEmail);
		
		input.inputOTP(otp_forgot);
		test.pass("Successfully Input Text Field OTP with Valid Numbers");
		System.out.println("Done Input OTP");
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Register Submit Button");
	}
}
