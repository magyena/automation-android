package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public RegisterPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	 @AndroidFindBy(xpath="//*[contains(@text,'Send OTP')]")
	 public static WebElement btn_send_otp;
	 
	 @AndroidFindBy(xpath="//android.widget.EditText[3]")
	 public static WebElement fld_otp;

	 @AndroidFindBy(xpath="//android.widget.TextView[2]")
	 public static WebElement txt_warning_phone_number;
	 
	 @AndroidFindBy(xpath="//android.widget.TextView[2]")
	 public static WebElement txt_warning_incorrect_format;
	 
	 @AndroidFindBy(xpath="//android.widget.TextView[3]")
	 public static WebElement txt_warning_password_email;
	 
	 @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.widget.TextView[1]")
	 public static WebElement txt_pop_up_existing_account;
	 
	 @AndroidFindBy(xpath="//*[contains(@text,'Login')]")
	 public static WebElement btn_login_pop_up;
	 
	 @AndroidFindBy(xpath="//android.widget.TextView[4]")
	 public static WebElement txt_warning_password_phone;
	 
	 @AndroidFindBy(xpath="//android.widget.TextView[6]")
	 public static WebElement txt_warning_otp;
	 
	 @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]/android.view.View/android.view.View/android.widget.Button")
	 public static WebElement img_password_visible;
	 
	 @AndroidFindBy(xpath ="//*[starts-with(@text,'Resend in')]")
	 public static WebElement txt_timer;
	
	 @AndroidFindBy(xpath="/hierarchy/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.TextView")
	 public static WebElement txt_no_country_found;
	
	 @AndroidFindBy(xpath="/hierarchy/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	 public static WebElement txt_fld_country_code;
	 
	 @AndroidFindBy(xpath="/hierarchy/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]") 
	 public static WebElement btn_close_country_code;
	 
	 @AndroidFindBy(xpath="/hierarchy/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.widget.TextView[1]") 
	 public static WebElement btn_country_1;
	 
	 @AndroidFindBy(xpath="/hierarchy/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.widget.TextView[1]") 
	 public static WebElement btn_country_2;
	 
	 @AndroidFindBy(xpath="//android.widget.TextView") 
	 public static WebElement txt_country_code;
	
	 @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]/android.view.View/android.view.View/android.view.View") 
	 public static WebElement icon_country_code;
	 
	 @AndroidFindBy(xpath="//android.view.View[1]/android.widget.TextView[1]")
	 public static WebElement txt_register_title;
	 
	 @AndroidFindBy(xpath="//*/android.view.View[2]/android.widget.Button") 
	 public static WebElement btn_register_login_submit;
	 
	 @AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.EditText[1]") 
	 public static WebElement txt_fld_phone;

	 @AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.EditText[1]") 
	 public static WebElement txt_fld_email;
	 
	 @AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.EditText[2]") 
	 public static WebElement txt_fld_password;
}
