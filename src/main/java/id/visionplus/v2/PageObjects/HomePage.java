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
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/search_button")
	public static WebElement btn_search;
	
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
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/profileButton")
	public static WebElement btn_profile;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/add_profile_button")
	public static WebElement btn_add_profile;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/done_button")
	public static WebElement btn_add_profile_done;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/profileName")
	public static WebElement txt_fld_add_profile_name;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/popup_message")
	public static WebElement txt_profile_pop_up_existing_profile;
	
	@AndroidFindBy(xpath="//*[contains(@text,'OK')]")
	public static WebElement btn_add_profile_ok;
	
	@AndroidFindBy(id="android:id/button1")
	public static WebElement btn_existing_profile_ok;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/cancel_button")
	public static WebElement btn_cancel_almost_done;

	@AndroidFindBy(xpath="//*[contains(@text,'CANCEL')]")
	public static WebElement btn_add_profile_cancel;
	
	@AndroidFindBy(xpath="(//android.widget.ImageView[@content-desc=\"false\"])[1]")
	public static WebElement img_1st_profile;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Live TV')]")
	public static WebElement btn_live_tv;
	
	@AndroidFindBy(xpath="//*[contains(@text,'My Downloads')]")
	public static WebElement btn_my_download;
	
	@AndroidFindBy(xpath="(//androidx.recyclerview.widget.RecyclerView/android.view.View[1])[2]")
	public static WebElement img_visionplus_originals_content;
	
	@AndroidFindBy(xpath="(/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[4]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.View[3]")
	public static WebElement img_top_10_series;
	
	@AndroidFindBy(xpath="(/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.View")
	public static WebElement img_live_tv;

}
