package id.visionplus.v2.TestCase.Free;

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

public class TC_Integrate_Register_Email extends BaseTest{

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	TC_Get_OTP get_otp= new TC_Get_OTP();
	String email=email_random();
	
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
	public void TC_user_input_valid_email_and_password()throws InterruptedException, TimeoutException{
		
		input.inputEmail(email);
		test.pass("Successfully Input Text Field Email with Valid Email");
		
		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		Thread.sleep(3000);
		input.inputPassword("4321Lupa");
		test.pass("Successfully Input Text Field Password with Valid Password");
	
		click.clickSendOTP();
		test.pass("Successfully Clicked Send OTP");
	}
	
	@Test(priority = 7, dependsOnMethods = "TC_user_input_valid_email_and_password")
	public void TC_user_input_correct_otp()throws InterruptedException, IOException{
		Thread.sleep(2000);
		
		click.clickOtpFld();
		test.pass("Successfully Click Text Field OTP");

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
}
