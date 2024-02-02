package id.visionplus.v2.Action;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.PageObjects.EntryPage;
import id.visionplus.v2.PageObjects.RegisterPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Click extends BaseTest
{
	WebDriverWait wait;	
	Scroll scroll;
	EntryPage entryPage;
	RegisterPage registerPage;
	
	public void pressBack(){
        (android).pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public void clickLogin(){
		entryPage = new EntryPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_login = entryPage.btn_login;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_login));
	    btn_login.click();
	}
	
	public void clickTerms(){
		entryPage = new EntryPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_terms_of_use = entryPage.btn_terms_of_use;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_terms_of_use));
	    btn_terms_of_use.click();
	}
	
	public void clickPrivacy(){
		entryPage = new EntryPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_privacy_policy = entryPage.btn_privacy_policy;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_privacy_policy));
	    btn_privacy_policy.click();
	}
	
	public void clickRegister(){
		entryPage = new EntryPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_register = entryPage.btn_register;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_register));
	    btn_register.click();
	}
	
	public void clickCountry(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement icon_country_code = registerPage.icon_country_code;
	    wait.until(ExpectedConditions.visibilityOfAllElements(icon_country_code));
	    icon_country_code.click();
	}
	
	public void clickFieldCountry(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_country_code = registerPage.txt_fld_country_code;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_country_code));
	    txt_fld_country_code.click();
	}
	
	public void clickCloseCountry(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_close_country = registerPage.btn_close_country_code;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_close_country));
	    btn_close_country.click();
	}
	
	public void clickFieldPhoneNumber(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_phone = registerPage.txt_fld_phone;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_phone));
	    txt_fld_phone.click();
	}
	
	public void clickFieldPassword(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_password = registerPage.txt_fld_password;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_password));
	    txt_fld_password.click();
	}
	
	public void clickSendOTP(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_password = registerPage.txt_fld_password;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_password));
	    txt_fld_password.click();
	}
	
	public void clickOtpFld1(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_otp_1 = registerPage.txt_fld_otp_1;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_otp_1));
	    txt_fld_otp_1.click();
	}
	
	public void clickOtpFld2(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_otp_2 = registerPage.txt_fld_otp_2;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_otp_2));
	    txt_fld_otp_2.click();
	}
	
	public void clickOtpFld3(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_otp_3 = registerPage.txt_fld_otp_3;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_otp_3));
	    txt_fld_otp_3.click();
	}
	
	public void clickOtpFld4(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_otp_4 = registerPage.txt_fld_otp_4;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_otp_4));
	    txt_fld_otp_4.click();
	}
	
	public void clickRegisterLoginSubmitButton(){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_register_login_submit = registerPage.btn_register_login_submit;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_register_login_submit));
	    btn_register_login_submit.click();
	}
}
