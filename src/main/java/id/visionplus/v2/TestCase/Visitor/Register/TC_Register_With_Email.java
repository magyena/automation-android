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
import id.visionplus.v2.TestCase.General.*;

public class TC_Register_With_Email extends BaseTest{

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
	public void TC_user_input_valid_email_and_password()throws InterruptedException{	
		input.inputEmail(email);
		System.out.println(email);
		test.pass("Successfully Input Text Field Email with Valid Email");

		input.clearPasswordField();
		test.pass("Successfully Empty Text Field Password");
		
		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		Thread.sleep(3000);
		input.inputPassword("4321Lupa");
		test.pass("Successfully Input Text Field Password with Valid Password");
	}
	
	@Test(priority = 3, dependsOnMethods = "TC_user_input_valid_email_and_password")
	public void TC_user_cannot_input_wrong_otp()throws InterruptedException{	
		click.clickSendOTP();
		test.pass("Successfully Clicked Send OTP");
		
		click.clickOtpFld();
		test.pass("Successfully Click Text Field OTP");

		input.inputOTP("1234");
		test.pass("Successfully Input Text Field OTP with Invalid Numbers");
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Send Register Submit Button");
		
		assertion.assertTextWarningOTP();
		test.pass("Successfully Assert Text Warning OTP is Displayed");
	}
	
	@Test(priority = 4, dependsOnMethods = "TC_user_cannot_input_wrong_otp")
	public void TC_user_input_correct_otp()throws InterruptedException, IOException{
		input.clearOTP();
		test.pass("Successfully Clear Text Field OTP");

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
