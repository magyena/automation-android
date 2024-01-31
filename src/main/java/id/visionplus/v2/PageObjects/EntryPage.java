package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EntryPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public EntryPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/privacy_policy") 
	 public static WebElement btn_privacy_policy;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/terms_of_use") 
	 public static WebElement btn_terms_of_use;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/register_button") 
	 public static WebElement btn_register;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/login_button") 
	 public static WebElement btn_login;
	 
	 @AndroidFindBy(xpath="//android.widget.Button") 
	 public static WebElement txt_widget_terms_privacy;
}
