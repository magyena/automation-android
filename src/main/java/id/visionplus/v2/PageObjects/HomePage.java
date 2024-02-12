package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public HomePage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/settings_button")
	public static WebElement btn_settings;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/menuButton")
	public static WebElement btn_menu;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/stripActionButton")
	public static WebElement btn_view_all;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/welcomeText")
	public static WebElement txt_welcome;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/profiles_discover")
	public static WebElement txt_discover;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/profiles_skip")
	public static WebElement btn_skip;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/continue_button")
	public static WebElement btn_continue;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/appLogo")
	public static WebElement img_visionplus_logo;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/container_banner_info")
	public static WebElement img_banner_info;
	
	@AndroidFindBy(xpath="(//android.widget.ImageView[@content-desc=\"false\"])[1]")
	public static WebElement img_1st_profile;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Live TV')]")
	public static WebElement btn_live_tv;
	
	@AndroidFindBy(xpath="(/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.View[1]")
	public static WebElement img_visionplus_originals_content;
}
