package id.visionplus.v2.Action;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import expectj.TimeoutException;
import id.visionplus.v2.MainFunction.*;
import id.visionplus.v2.PageObjects.EntryPage;
import id.visionplus.v2.PageObjects.HomePageVisionPlus;
import id.visionplus.v2.PageObjects.RegisterPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.ElementOption;

public class Click extends BaseTest
{
	WebDriverWait wait;	
	Scroll scroll;
	EntryPage entryPage;
	RegisterPage registerPage;
	
	public void pressBack() {
        (android).pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public void clickLogin() {
		entryPage = new EntryPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_login = entryPage.btn_login;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_login));
	    btn_login.click();
	}
	
	public void clickTerms() {
		entryPage = new EntryPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_terms_of_use = entryPage.btn_terms_of_use;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_terms_of_use));
	    btn_terms_of_use.click();
	}
	
	public void clickPrivacy() {
		entryPage = new EntryPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_privacy_policy = entryPage.btn_privacy_policy;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_privacy_policy));
	    btn_privacy_policy.click();
	}
	
	public void clickRegister() {
		entryPage = new EntryPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement btn_register = entryPage.btn_register;
	    wait.until(ExpectedConditions.visibilityOfAllElements(btn_register));
	    btn_register.click();
	}
	
	public void clickCountry() {
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement icon_country_code = registerPage.icon_country_code;
	    wait.until(ExpectedConditions.visibilityOfAllElements(icon_country_code));
	    icon_country_code.click();
	}
	
	public void clickFieldCountry() {
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement txt_fld_country_code = registerPage.txt_field_country_code;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_country_code));
	    txt_fld_country_code.click();
	}
}
