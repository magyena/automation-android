package id.visionplus.v2.Action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.PageObjects.RegisterPage;
import io.appium.java_client.android.AndroidDriver;

public class Input extends BaseTest
{
	WebDriverWait wait;
	RegisterPage registerPage;
	
	Click click = new Click();

	public void inputPhoneNumber(String keyword){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_phone = registerPage.txt_fld_phone;
	    txt_fld_phone.sendKeys(keyword);
	}
	
	public void inputEmail(String keyword){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_email = registerPage.txt_fld_email;
	    txt_fld_email.sendKeys(keyword);
	}
	
	public void inputPassword(String keyword){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_password = registerPage.txt_fld_password;
	    txt_fld_password.sendKeys(keyword);
	}
	
	public void inputCountryKeyword(String keyword){
	    registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_country_code = registerPage.txt_fld_country_code;
	    txt_fld_country_code.sendKeys(keyword);
	}
	
	public void clearCountryCodeField(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_country_code = registerPage.txt_fld_country_code;
	    txt_fld_country_code.clear();
	}
	
	public void clearPhoneNumberField(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_phone = registerPage.txt_fld_phone;
	    txt_fld_phone.clear();
	}
	
	public void clearEmailField(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_email = registerPage.txt_fld_email;
	    txt_fld_email.clear();
	}
	
	public void clearPasswordField(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_password = registerPage.txt_fld_password;
	    txt_fld_password.clear();
	}
	
	public void inputOTP(String otp) throws InterruptedException{
	    registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement fld_otp = registerPage.fld_otp;

	    String existingText = fld_otp.getAttribute("text");

	    // Loop through each character of the OTP string
	    for (int i = 0; i < 4; i++) {
	        // Get the digit at position i
	        char digit = otp.charAt(i);

	        // Append the current digit to the existing text
	        existingText += digit;	        
	        fld_otp.sendKeys(existingText);
	    }
	}
	
	public void clearOTP(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement fld_otp = registerPage.fld_otp;
	    fld_otp.clear();;
	}
	
	private WebElement findKeyboardKeyByDigit(char digit) {
        String keyId = "key" + digit;
        return android.findElement(By.id(keyId));
    }
}