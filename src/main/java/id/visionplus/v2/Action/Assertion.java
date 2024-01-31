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
		WebElement btn_register_submit = registerPage.btn_register_submit;
				
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
}
