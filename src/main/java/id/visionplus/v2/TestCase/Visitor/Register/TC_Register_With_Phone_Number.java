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

public class TC_Register_With_Phone_Number extends BaseTest{

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
	TC_Get_OTP get_otp= new TC_Get_OTP();
	String phone_number=epoch_random();
	
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
		input.inputPhoneNumber(phone_number);
		test.pass("Successfully Input Text Field Phone Number with Valid Numbers");	

		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		input.inputPassword("lupa4321");
		test.pass("Successfully Input Text Field Password with Valid Password");
		
		Thread.sleep(3000);
		assertion.assertTextWarningPassword();
		test.pass("Successfully Assert Text Warning Password is Displayed");
	}
	
	@Test(priority = 4, dependsOnMethods = "TC_user_cannot_input_password_without_uppercase")
	public void TC_user_input_valid_phone_number_and_password()throws InterruptedException{	
		input.clearPasswordField();
		test.pass("Successfully Empty Text Field Password");
		
		click.clickFieldPassword();
		test.pass("Successfully Clicked Text Field Password");
		
		Thread.sleep(3000);
		input.inputPassword("4321Lupa");
		test.pass("Successfully Input Text Field Password with Valid Password");
	}
	
	@Test(priority = 5, dependsOnMethods = "TC_user_input_valid_phone_number_and_password")
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
	
	@Test(priority = 5, dependsOnMethods = "TC_user_cannot_input_wrong_otp")
	public void TC_user_input_correct_otp()throws InterruptedException, IOException{
		input.clearOTP();
		test.pass("Successfully Clear Text Field OTP");

		click.clickOtpFld();
		test.pass("Successfully Click Text Field OTP");

		//Get OTP from DB
		String res_otp = get_otp.get_OTP(phone_number);
	    input.inputOTP(res_otp);
		test.pass("Successfully Input Text Field OTP with Valid Numbers");
		
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
