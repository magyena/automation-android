package id.visionplus.v2.Action;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.PageObjects.RegisterPage;
//import id.visionplus.v2.PageObjects.LoginPageVisionPlus;
import io.appium.java_client.android.AndroidDriver;

public class Input extends BaseTest
{
	WebDriverWait wait;
	RegisterPage registerPage;
	
	Click click = new Click();

	public void inputCountryKeyword(String keyword){
		registerPage = new RegisterPage(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(90));
	    WebElement txt_fld_country_code = registerPage.txt_field_country_code;
	    wait.until(ExpectedConditions.visibilityOfAllElements(txt_fld_country_code));
	    txt_fld_country_code.sendKeys(keyword);
	}
}