package id.visionplus.v2.Action;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import id.visionplus.v2.MainFunction.*;
import id.visionplus.v2.PageObjects.*;

public class Assertion extends BaseTest
{
	WebDriverWait wait;
	EntryPage entryPage;
	HomePage homePage = new HomePage(android);
	RegisterPage registerPage;
	
	public void assertTermsOfUsePageInd() {
		WebElement txt_widget_title = entryPage.txt_widget_terms_privacy;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_widget_title));
	    
	    String actual = txt_widget_title.getText();
	    String expected = "Syarat & Ketentuan";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertPrivacyPolicyPageInd() {
		WebElement txt_widget_title = entryPage.txt_widget_terms_privacy;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_widget_title));
	    
	    String actual = txt_widget_title.getText();
	    String expected = "Kebijakan Privasi";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertRegisterLoginPage(){
		registerPage = new RegisterPage(android);
		
		WebElement txt_register_title = registerPage.txt_register_title;
		WebElement txt_fld_phone = registerPage.txt_fld_phone;
		WebElement txt_fld_password = registerPage.txt_fld_password;
		WebElement btn_register_submit = registerPage.btn_register_login_submit;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
		
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_register_title));

	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_phone));
	    
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_password));
	    
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_register_submit));
	    	    
	    Assert.assertTrue(txt_register_title.isDisplayed());

	    Assert.assertTrue(txt_fld_phone.isDisplayed());

	    Assert.assertTrue(txt_fld_password.isDisplayed());

	    Assert.assertTrue(btn_register_submit.isDisplayed());
	}
	
	public void assertDropDownCountry(){
		WebElement txt_country_code = registerPage.txt_country_code;
		WebElement btn_country_1 = registerPage.btn_country_1;
		WebElement btn_country_2 = registerPage.btn_country_2;

		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_country_code));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_country_1));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_country_2));

	    String actual1 = txt_country_code.getText();
	    String expected1 = "Country Code";
	    Assert.assertEquals(actual1, expected1);
	    
	    String actual2 = btn_country_1.getText();
	    String expected2 = "Indonesia";
	    Assert.assertEquals(actual2, expected2);
	    
	    String actual3 = btn_country_2.getText();
	    String expected3 = "Malaysia";
	    Assert.assertEquals(actual3, expected3);
	}
	
	public void assertFilteredCountryKeyword(String keyword) {
		WebElement btn_country_1 = registerPage.btn_country_1;
		
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_country_1));
	    
	    String actual = btn_country_1.getText();
	    String expected = keyword;
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertInvalidFilteredCountryKeyword() {
		WebElement txt_no_country_found = registerPage.txt_no_country_found;	
		String actual = txt_no_country_found.getText();
	    String expected = "No country code found.";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertPhoneFieldIsEmpty() {
		WebElement txt_fld_phone = registerPage.txt_fld_phone;	
		String actual = txt_fld_phone.getText();
	    String expected = "";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertTextWarningPhoneNumber() {
		WebElement txt_warning_phone_number = registerPage.txt_warning_phone_number;	
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_phone_number));
	    
	    Assert.assertTrue(txt_warning_phone_number.isDisplayed());
	    
	    String actual = txt_warning_phone_number.getText();
	    String expected = "Phone number incorrect.";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertTextWarningPassword() {
		WebElement txt_warning_password = registerPage.txt_warning_password;	
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_password));
	    
	    Assert.assertTrue(txt_warning_password.isDisplayed());
	    
	    String actual = txt_warning_password.getText();
	    String expected = "Your password must be at least 8 characters with a mix of uppercase-lowercase letters and numbers";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertTextWarningOTP() {
		WebElement txt_warning_otp = registerPage.txt_warning_otp;	
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_warning_otp));
	    
	    Assert.assertTrue(txt_warning_otp.isDisplayed());
	    
	    String actual = txt_warning_otp.getText();
	    String expected = "Wrong OTP code";
	    Assert.assertEquals(actual, expected);
	}
	
	public void assertWelcomeText() {
		homePage = new HomePage(android);
		
		WebElement txt_welcome = homePage.txt_welcome;
				
		wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_welcome));
	    
	    Assert.assertTrue(txt_welcome.isDisplayed());
	    
	    String actual = txt_welcome.getText();
	    String expected = "Hello!";
	    Assert.assertEquals(actual, expected);
	}
}
