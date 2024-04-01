package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OutsideApp extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public OutsideApp(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(xpath="//*[contains(@text,'Next episode')]")
	public static WebElement btn_next_episode;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"WhatsApp Main Page\"]/android.widget.Image")
	public static WebElement img_whatsApp_logo_header;
	
	@AndroidFindBy(id="com.google.android.gm:id/peoplekit_chip")
	public static WebElement img_gmail_from;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Log In')]")
	public static WebElement btn_login_facebook;
	
	@AndroidFindBy(xpath="//*/android.widget.Button[1]")
	public static WebElement btn_continue_as_facebook;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\"]")
	public static WebElement btn_profile_playstore;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\" and @text=\"Payments & subscriptions\"]")
	public static WebElement btn_Payment_Subscriptions_playstore;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\" and @text=\"Subscriptions\"]")
	public static WebElement btn_subscriptions_playstore;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Premium 30 Days')]")
	public static WebElement history_premium_30_days_playstore;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Premium Sports 30 Days')]")
	public static WebElement history_premium_sports_30_days_playstore;
	
	@AndroidFindBy(xpath="//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[4]/android.widget.Button")
	public static WebElement btn_cancel_subscription_playstore;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\" and @text=\"No thanks\"]")
	public static WebElement btn_no_thanks_playstore;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text=\"Decline to answer\"]")
	public static WebElement btn_radio_cancel_playstore;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\"]")
	public static WebElement btn_continue_playstore;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\" and @text=\"Cancel subscription\"]")
	public static WebElement btn_confirm_cancel_playstore;
	
	@AndroidFindBy(xpath="//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.Button")
	public static WebElement btn_back_to_list_history_playstore;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Premium 30 Days')]")
	public static WebElement txt_premium30_days_playstore;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Premium Sports 30 Days')]")
	public static WebElement txt_premiumSports30_days_playstore;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\"]")
	public static WebElement btn_subscribe_playstore;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public static WebElement btn_accept;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\" and @text=\"Error\"]")
	public static WebElement txt_error_subscribe_playstore;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\"]")
	public static WebElement btn_got_it;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\"]\n")
	public static WebElement btn_subscriptions_playstore_again;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
