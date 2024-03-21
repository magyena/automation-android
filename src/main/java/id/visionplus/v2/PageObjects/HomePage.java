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
	//Test Push
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
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.View[1]")
	public static WebElement img_visionplus_originals_content;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Top 10 This Week')]/following::android.view.View[1]")
	public static WebElement img_visionplus_originials_top_1_content;

	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'TV, Love, Cinema')]/following::android.view.View[1]")
	public static WebElement img_tv_love_cinema_content;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Indonesian Comedy Series')]/following::android.view.View[1]")
	public static WebElement img_comedy_content;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Asian Action Movies')]/following::android.view.View[1]")
	public static WebElement img_asian_action_movies;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[4]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.View[3]")
	public static WebElement img_top_10_series;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.View[1]")
	public static WebElement img_live_tv;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Your Favorite TV Channel')]/following::android.view.View[1]")
	public static WebElement img_live_tv_cluster;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Popular Actors')]/following::android.view.View[1]")
	public static WebElement img_popular_actors_1;
		
	@AndroidFindBy(xpath="(//android.view.View[1])[1]")
	public static WebElement img_popular_actors_series;
	
	@AndroidFindBy(xpath="(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/stripRecyclerView\"])[1]/android.view.View[1]")
	public static WebElement img_originals; 
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/title\" and @text=\"Home\"]" )
	public static WebElement img_home; 

	@AndroidFindBy(id ="com.zte.iptvclient.android.idmnc:id/container_banner_info" )
	public static WebElement btn_play_lastBanner; 
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/title\" and @text=\"Program Guide\"]" )
	public static WebElement btn_program_guide; 
	
	@AndroidFindBy(id ="com.zte.iptvclient.android.idmnc:id/templateTitle" )
	public static WebElement txt_tittle_view_all; 
	
	@AndroidFindBy(id ="(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/stripRecyclerView\"])[2]/android.view.View[2]" )
	public static WebElement img_series; 
	
	
	
}
