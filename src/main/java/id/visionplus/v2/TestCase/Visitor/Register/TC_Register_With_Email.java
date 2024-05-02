package id.visionplus.v2.TestCase.Visitor.Register;

/* Created Date	: 3 April 2024
 * Updated by	: Michael
 * Updated Date	: 30 April 2024
 * 1. Adding Sleep before assert Homepage
 * */

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.*;

public class TC_Register_With_Email extends BaseTest{

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	TC_Get_OTP get_otp= new TC_Get_OTP();
	BaseTest base = new BaseTest();
	String email=email_random();
	String existing_email="freetest39@visionplus.id";
	
	public String email_random(){
		long epochTime = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
        String formattedTime = dateFormat.format(new Date(epochTime));
        String result = "visionplus" + formattedTime.substring(0, Math.max(0, 20 - "visionplus".length())) + "@visionplus.id";
        return result;
	}
	
	@Test(priority = 1)
	public void TC_access_register_by_email_page() throws InterruptedException, TimeoutException {
		click.clickRegister();
		test.pass("Successfully Clicked Register Button");
		Thread.sleep(3000);
		
		click.clickRegisterLoginByEmailSection();
		test.pass("Successfully Clicked Register by Email Button");

		assertion.assertRegisterLoginPage();
		test.pass("Successfully Assert Register Page");
	}
	
	@Test(priority = 2, dependsOnMethods = "TC_access_register_by_email_page")
	public void TC_user_input_invalid_email()throws InterruptedException{	
		input.inputEmail("freetest");
		test.pass("Successfully Input Text Field Email with Invalid Email");
		
		assertion.assertEmailIncorrectFormat();
		test.pass("Successfully Assert Email with invalid Format");
	}
	
	@Test(priority = 3, dependsOnMethods = "TC_user_input_invalid_email")
	public void TC_user_input_invalid_password()throws InterruptedException{	
		input.clearEmailField();
		test.pass("Successfully Empty Text Field Email");
		
		input.inputEmail(existing_email);
		test.pass("Successfully Input Text Field Email with Valid Email");
		
		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		Thread.sleep(3000);
		input.inputPassword("lupa43");
		test.pass("Successfully Input Text Field Password with Invalid Password");
		
		assertion.assertTextWarningPasswordEmail();
		test.pass("Successfully Assert Text Warning Password is Displayed");
	}
	
	@Test(priority = 3, dependsOnMethods = "TC_user_input_invalid_password")
	public void TC_user_input_existing_account()throws InterruptedException{	
		input.clearPasswordField();
		test.pass("Successfully Empty Text Field Password");
		
		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		Thread.sleep(3000);
		input.inputPassword("4321Lupa");
		test.pass("Successfully Input Text Field Password with valid Password");

		click.clickSendOTP();
		test.pass("Successfully Clicked Send OTP");
		
		assertion.assertPopUpExistingAccount();
		test.pass("Successfully Assert Pop Up Existing Account");
	}
	
	@Test(priority = 3, dependsOnMethods = "TC_user_input_existing_account")
	public void TC_user_redirect_to_login()throws InterruptedException{	
		click.clickLoginPopUp();
		test.pass("Successfully Clicked Login Button in Existing Account Pop Up");

		assertion.assertRegisterLoginPage();
		test.pass("Successfully Assert Login Page");
		
		//back to Entry Page
		click.pressBack();
		test.pass("Successfully Pressed Back Button");
	}
	
	@Test(priority = 4, dependsOnMethods = "TC_user_redirect_to_login")
	public void TC_user_input_valid_email_and_password()throws InterruptedException, TimeoutException{
		//Access Register by Email Page
		TC_access_register_by_email_page();
		
		input.inputEmail(email);
		test.pass("Successfully Input Text Field Email with Valid Email");
		
		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		Thread.sleep(3000);
		input.inputPassword("4321Lupa");
		test.pass("Successfully Input Text Field Password with Valid Password");
	}
	
	@Test(priority = 5, dependsOnMethods = "TC_user_input_valid_email_and_password")
	public void TC_user_cannot_input_wrong_otp()throws InterruptedException{	
		click.clickSendOTP();
		test.pass("Successfully Clicked Send OTP");
		
		Thread.sleep(10000);
				
		while(!android.isKeyboardShown()){
			click.clickOtpFld();
			test.pass("Successfully Click Text Field OTP");
		}

		input.inputOTP("1234");
		test.pass("Successfully Input Text Field OTP with Invalid Numbers");
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Send Register Submit Button");
		
		Thread.sleep(2000);
		
		assertion.assertTextWarningOTPWrong();
		test.pass("Successfully Assert Text Warning OTP is Displayed");
	}
	
	@Test(priority = 6, dependsOnMethods = "TC_user_cannot_input_wrong_otp")
	public void TC_user_click_send_otp_2nd_time()throws InterruptedException, IOException{
		//Wait until 2 Minutes
		Thread.sleep(120000);
		
		click.clickSendOTP();
		test.pass("Successfully Clicked Send OTP");
		
		Thread.sleep(10000);
		
		assertion.assertTimer5Minutes();
		test.pass("Successfully Assert Timer 5 Minutes");
	}
	
	@Test(priority = 7, dependsOnMethods = "TC_user_click_send_otp_2nd_time")
	public void TC_user_input_correct_otp()throws InterruptedException, IOException{
		Thread.sleep(2000);

		input.clearOTP();
		test.pass("Successfully Clear Text Field OTP");
		
		while(!android.isKeyboardShown()){
			System.out.println("Try Click OTP Field");
			click.clickOtpFld();
			test.pass("Successfully Click Text Field OTP");
		}

		//Get OTP from DB
		String res_otp = get_otp.get_OTP(email);
	    input.inputOTP(res_otp);
		test.pass("Successfully Input Text Field OTP with Valid Email");
		
		Thread.sleep(3000);
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Send Register Submit Button");
		
		Thread.sleep(3000);
	
		assertion.assertDiscoverText();
		test.pass("Successfully Assert Discover Profile Text After Login");
		
		click.clickSkip();
		test.pass("Successfully Click Skip Button");
		
		click.clickContinue();
		test.pass("Successfully Click Continue Button");
		
		assertion.assertArriveHomePage();
		test.pass("Successfully Assert Arrived at Homepage");
	}
	
	@Test(priority = 8, dependsOnMethods = "TC_user_input_correct_otp")
	public void TC_register_again_after_kill_apps()throws InterruptedException, IOException, TimeoutException{
		System.out.println("DONE REGISTER - PROCEED TO KILL APPS");
		TC_Logout tc_logout = new TC_Logout();
		
		//logout first
		tc_logout.TC_Access_Settings();
		tc_logout.TC_Access_Logout();
		
		android.closeApp();
		base.ConfigureAppium();
		
		Thread.sleep(2000);
		
		TC_access_register_by_email_page();
		
		//input based on epoch existing random email
		input.inputEmail(email);
		test.pass("Successfully Input Text Field Email with Already Registered Email");

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		input.inputPassword("4321Lupa");
		test.pass("Successfully Input Text Field Password with Valid Password");
		
		click.clickSendOTP();
		test.pass("Successfully Clicked Send OTP");
		
		assertion.assertPopUpExistingAccount();
		test.pass("Successfully Assert Pop Up Existing Account");
	}
}
