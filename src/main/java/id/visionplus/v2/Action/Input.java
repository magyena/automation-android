package id.visionplus.v2.Action;

import java.time.Duration;

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
	
	public void clearPasswordField(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_password = registerPage.txt_fld_password;
	    txt_fld_password.clear();
	}
	
	public void inputOTP1(String otp){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_otp_1 = registerPage.txt_fld_otp_1;
	    txt_fld_otp_1.sendKeys(otp);
	}
	
	public void inputOTP2(String otp){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_otp_2 = registerPage.txt_fld_otp_2;
	    txt_fld_otp_2.sendKeys(otp);
	}
	
	public void inputOTP3(String otp){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_otp_3 = registerPage.txt_fld_otp_3;
	    txt_fld_otp_3.sendKeys(otp);
	}
	
	public void inputOTP4(String otp){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_otp_4 = registerPage.txt_fld_otp_4;
	    txt_fld_otp_4.sendKeys(otp);
	}
}