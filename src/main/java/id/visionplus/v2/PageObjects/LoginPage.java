package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public LoginPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	 @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.widget.TextView[1]")
	 public static WebElement txt_unregistered_account;
	 
	 @AndroidFindBy(xpath="/hierarchy/android.widget.Toast")
	 public static WebElement txt_wrong_email_password;
	 
	 @AndroidFindBy(xpath="//*/android.widget.TextView[contains(@text, 'Email')]")
	 public static WebElement btn_login_by_email_section;
	 
	 @AndroidFindBy(xpath="//*[contains(@text,'Forgot Password?')]")
	 public static WebElement btn_forgot_password;
	 
	 @AndroidFindBy(xpath="//android.view.View[@content-desc=\"GOOGLE\"]")
	 public static WebElement btn_login_by_google;
	 
	 @AndroidFindBy(xpath="//android.view.View[@content-desc=\"FACEBOOK\"]")
	 public static WebElement btn_login_by_facebook;
	 
	 @AndroidFindBy(id="com.google.android.gms:id/account_display_name")
	 public static WebElement btn_google_account_1;	 

}
