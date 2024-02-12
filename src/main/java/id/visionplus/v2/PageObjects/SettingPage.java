package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public SettingPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView")
	public static WebElement btn_profile;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.TextView[1]")
	public static WebElement txt_settings_section_help_centre;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Subcription & Transaction')][1]")
	public static WebElement txt_help_section_Subcription;
	
	@AndroidFindBy(xpath="//*[contains(@text,'About Us')][1]")
	public static WebElement txt_help_section_About_Us;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"About Us\"]/android.widget.TextView")
	public static WebElement btn_help_about_us;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Image[1]")
	public static WebElement btn_back_to_help;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Subscription & Transaction\"]/android.widget.TextView")
	public static WebElement btn_help_subscription_transaction;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Help')]")
	public static WebElement btn_help;
	
	@AndroidFindBy(xpath="//*[contains(@text, 'Manage profiles')]")
	public static WebElement btn_manage_profile;
	
	@AndroidFindBy(xpath="//*[contains(@text, 'Notification centre')]")
	public static WebElement btn_notification_centre;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/close")
	public static WebElement btn_help_close;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/toolbar_text")
	public static WebElement txt_settings_section_title;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/back")
	public static WebElement btn_back;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/close_session_button")
	public static WebElement btn_logout;

}
