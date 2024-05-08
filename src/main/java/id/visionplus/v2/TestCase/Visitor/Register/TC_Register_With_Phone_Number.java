package id.visionplus.v2.TestCase.Visitor.Register;

/* Created Date	: 4 April 2024
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
import id.visionplus.v2.TestCase.Visitor.Login.TC_Login_As_Free_User_Phone;

public class TC_Register_With_Phone_Number extends BaseTest{

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	TC_Get_OTP get_otp= new TC_Get_OTP();
	String phone_number=epoch_random();
	BaseTest base = new BaseTest();
	String existing_phone_number="899012345678";
	String prev_otp = "";
	String new_pass = "Lupa4321";
	
	public String epoch_random(){
		long epochTime = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
        String formattedTime = dateFormat.format(new Date(epochTime));
        String result = "899" + formattedTime.substring(0, Math.max(0, 13 - "899".length()));
        return result;
	}
	
	@Test(priority = 1)
	public void TC_access_register_page() throws InterruptedException, TimeoutException {
		click.clickRegister();
		test.pass("Successfully Clicked Register Button");
		Thread.sleep(3000);
		assertion.assertRegisterLoginPage();
		test.pass("Successfully Assert Register Page");
	}
	
	@Test(priority = 2, dependsOnMethods = "TC_access_register_page")
	public void TC_user_can_search_country_code(){
		click.clickCountry();
		test.pass("Successfully Clicked Country Code");
		assertion.assertDropDownCountry();
		test.pass("Successfully Assert Country Code Section");
	}
	
	@Test(priority = 3, dependsOnMethods = "TC_user_can_search_country_code")
	public void TC_user_can_filter_country_by_keyword(){
		click.clickFieldCountry();
		test.pass("Successfully Clicked Text Field Country Code");
		input.inputCountryKeyword("Indonesia");
		test.pass("Successfully Input Text Field Country Code with Keyword");
		assertion.assertFilteredCountryKeyword("Indonesia");
		test.pass("Successfully Assert Filtered Country Code");
		
		input.clearCountryCodeField();
		test.pass("Successfully Empty Text Field Country Code");
	}
	
	@Test(priority = 3, dependsOnMethods = "TC_user_can_search_country_code")
	public void TC_user_can_filter_country_by_code(){
		click.clickFieldCountry();
		test.pass("Successfully Clicked Text Field Country Code");
		input.inputCountryKeyword("60");
		test.pass("Successfully Input Text Field Country Code with Country Code");
		assertion.assertFilteredCountryKeyword("Malaysia");
		test.pass("Successfully Assert Filtered Country Code");
		
		input.clearCountryCodeField();
		test.pass("Successfully Empty Text Field Country Code");
	}
	
	@Test(priority = 3, dependsOnMethods = "TC_user_can_search_country_code")
	public void TC_user_filter_country_code_invalid()throws InterruptedException{
		click.clickFieldCountry();
		test.pass("Successfully Clicked Text Field Country Code");
		input.inputCountryKeyword("asdfgh");
		test.pass("Successfully Input Text Field Country Code with Invalid Keyword");
		Thread.sleep(3000);
		assertion.assertInvalidFilteredCountryKeyword();
		test.pass("Successfully Assert Invalid Filtered Country Code");
		
		input.clearCountryCodeField();
		test.pass("Successfully Empty Text Field Country Code");
		
		click.clickCloseCountry();
	}
	
	@Test(priority = 4, dependsOnMethods = "TC_user_filter_country_code_invalid")
	public void TC_user_cannot_input_characters_in_phone_field()throws InterruptedException{
		click.clickFieldPhoneNumber();
		test.pass("Successfully Clicked Text Field Phone Number");
		input.inputPhoneNumber("Number");
		test.pass("Successfully Input Text Field Phone Number with Characters(Invalid)");
		assertion.assertPhoneFieldIsEmpty();
		test.pass("Successfully Assert Text Field Phone Number is Not Filled with Characters");
	}
	
	@Test(priority = 4, dependsOnMethods = "TC_user_filter_country_code_invalid")
	public void TC_user_cannot_input_number_less_than_6_digit()throws InterruptedException{
		click.clickFieldPhoneNumber();
		test.pass("Successfully Clicked Text Field Phone Number");
		
		input.inputPhoneNumber("81112");
		test.pass("Successfully Input Text Field Phone Number with numbers less than 6 digits");
		
		assertion.assertTextWarningPhoneNumber();
		test.pass("Successfully Assert Text Warning Phone Number is Displayed");
		
		input.clearPhoneNumberField();
		test.pass("Successfully Empty Text Field Phone Number");
	}
	
	@Test(priority = 4, dependsOnMethods = "TC_user_cannot_input_number_less_than_6_digit")
	public void TC_user_cannot_input_password_without_uppercase()throws InterruptedException{
		click.clickFieldPhoneNumber();
		test.pass("Successfully Clicked Text Field Phone Number");
		
		//input based on epoch random phone number
		input.inputPhoneNumber(existing_phone_number);
		test.pass("Successfully Input Text Field Phone Number with Valid Existing Numbers");	

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		input.inputPassword("lupa4321");
		test.pass("Successfully Input Text Field Password with Valid Password");
		
		Thread.sleep(3000);
		assertion.assertTextWarningPasswordPhone();
		test.pass("Successfully Assert Text Warning Password is Displayed");
	}
	
	@Test(priority = 5, dependsOnMethods = "TC_user_cannot_input_password_without_uppercase")
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
		
		Thread.sleep(10000);
		
		assertion.assertPopUpExistingAccount();
		test.pass("Successfully Assert Pop Up Existing Account");
	}
	
	@Test(priority = 6, dependsOnMethods = "TC_user_input_existing_account")
	public void TC_user_redirect_to_login()throws InterruptedException{	
		click.clickLoginPopUp();
		test.pass("Successfully Clicked Login Button in Existing Account Pop Up");

		assertion.assertRegisterLoginPage();
		test.pass("Successfully Assert Login Page");
	}
	
	@Test(priority = 7, dependsOnMethods = "TC_user_redirect_to_login")
	public void TC_user_input_valid_phone_number_and_password()throws InterruptedException, TimeoutException{	
		//back to Entry Page
		click.pressBack();
		test.pass("Successfully Pressed Back Button");
		
		//Access Register by Phone Page
		TC_access_register_page();
		
		input.inputPhoneNumber(phone_number);
		test.pass("Successfully Input Text Field with Valid Phone Number");

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		System.out.println("Phone Number in Register: "+phone_number);
		
		Thread.sleep(3000);
		input.inputPassword("4321Lupa");
		test.pass("Successfully Input Text Field Password with Valid Password");
	}
	
	@Test(priority = 8, dependsOnMethods = "TC_user_input_valid_phone_number_and_password")
	public void TC_user_can_see_password()throws InterruptedException, TimeoutException{
		click.clickPasswordVisible();
		test.pass("Successfully Clicked Visible Password Icon");

		assertion.assertPasswordVisible();
		test.pass("Successfully Assert Visibility of Password as Text");
	}
	
	@Test(priority = 9, dependsOnMethods = "TC_user_can_see_password")
	public void TC_user_cannot_input_wrong_otp()throws InterruptedException{	
		click.clickSendOTP();
		test.pass("Successfully Clicked Send OTP");
				
		Thread.sleep(10000);
		
		assertion.assertTimer2Minutes();
		
		click.clickOtpFld();
		test.pass("Successfully Click Text Field OTP");
		
		input.inputOTP("1234");
		test.pass("Successfully Input Text Field OTP with Invalid Numbers");
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Send Register Submit Button");
		
		assertion.assertTextWarningOTPWrong();
		test.pass("Successfully Assert Text Warning OTP is Displayed");
	}
	
	@Test(priority = 10, dependsOnMethods = "TC_user_cannot_input_wrong_otp")
	public void TC_user_cannot_input_same_otp_after_2_minutes()throws InterruptedException, IOException{
		//Wait until 2 Minutes
		Thread.sleep(120000);
		
		input.clearOTP();
		test.pass("Successfully Clear Text Field OTP");

		click.clickOtpFld();
		test.pass("Successfully Click Text Field OTP");

		//Get OTP from DB
		String res_otp = get_otp.get_OTP(phone_number);
		prev_otp = res_otp;
		
	    input.inputOTP(res_otp);
		test.pass("Successfully Input Text Field OTP with Valid Numbers");
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Send Register Submit Button");
		
		Thread.sleep(3000);
		
		assertion.assertTextWarningOTPExpired();
		test.pass("Successfully Assert OTP Expired");
	}
	
	@Test(priority = 11, dependsOnMethods = "TC_user_cannot_input_same_otp_after_2_minutes")
	public void TC_user_click_send_otp_2nd_time()throws InterruptedException, IOException{
		click.clickSendOTP();
		test.pass("Successfully Clicked Send OTP");
		
		Thread.sleep(10000);
		
		assertion.assertTimer5Minutes();
		test.pass("Successfully Assert Timer 5 Minutes");
	}

	
	@Test(priority = 12, dependsOnMethods = "TC_user_click_send_otp_2nd_time")
	public void TC_user_input_correct_otp()throws InterruptedException, IOException{
		input.clearOTP();
		test.pass("Successfully Clear Text Field OTP");

		click.clickOtpFld();
		test.pass("Successfully Click Text Field OTP");
		System.out.println("Done Click OTP Field");
		
		//Get OTP from DB
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
	
	@Test(priority = 13, dependsOnMethods = "TC_user_input_correct_otp")
	public void TC_register_again_after_kill_apps()throws InterruptedException, IOException, TimeoutException{
		TC_Logout logout = new TC_Logout();
		logout.TC_Access_Settings();
		logout.TC_Access_Logout();
		
		android.closeApp();
		base.ConfigureAppium();
		
		Thread.sleep(2000);
		
		TC_access_register_page();
		
		//input based on epoch existing random email
		input.inputEmail(phone_number);
		test.pass("Successfully Input Text Field Email with Already Registered Email");

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		input.inputPassword(new_pass);
		test.pass("Successfully Input Text Field Password with Valid Password");
		
		click.clickSendOTP();
		test.pass("Successfully Clicked Send OTP");
		
		assertion.assertPopUpExistingAccount();
		test.pass("Successfully Assert Pop Up Existing Account");
	}
	
	@Test(priority = 14, dependsOnMethods = "TC_register_again_after_kill_apps")
	public void TC_Login_After_Forgot()throws InterruptedException, IOException, TimeoutException{
		TC_user_redirect_to_login();
		
		Thread.sleep(2000);
		
		click.clickFieldPhoneNumber();
		test.pass("Successfully Clicked Text Field Phone Number");
		
		input.clearPhoneNumberField();
		
		input.inputPhoneNumber(phone_number);
		test.pass("Successfully Input Text Field Phone Number with Valid Registered Numbers");	

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		input.clearPasswordField();
		
		input.inputPassword(new_pass);
		test.pass("Successfully Input Text Field Password with Valid Changed Password");
		
		android.hideKeyboard();
		
		click.clickRegisterLoginSubmitButton();
		test.pass("Successfully Clicked Login Submit Button");
		
		Thread.sleep(3000);
		
		assertion.assertHomePage();
		test.pass("Successfully Assert Homepage After Login");
	}
}
