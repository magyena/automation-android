package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LiveTVPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public LiveTVPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(xpath="(/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView")
	public static WebElement img_rcti;
	
	@AndroidFindBy(xpath="//*[contains(@text,'003')]")
	public static WebElement img_gtv;
	
	@AndroidFindBy(xpath="//*[contains(@text,'006')]")
	public static WebElement img_trans_tv;
	
	@AndroidFindBy(xpath="//*[contains(@text,'115')]")
	public static WebElement img_soccer_channel;
	
	@AndroidFindBy(xpath="//*[contains(@text,'SUBSCRIBE')]")
	public static WebElement btn_subscribe;
	
	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/live_tv_phone_channel_list_element_channel_info_info_button\"])[5]")
	public  static WebElement btn_detail_channel; //inno
	 
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.zte.iptvclient.android.idmnc:id/exo_subtitles\"]/android.view.View")
	public static WebElement detail_channel; //inno

	@AndroidFindBy(xpath="//*[contains(@text,'007')]")
	public static WebElement img_trans_7;
	
	@AndroidFindBy(xpath="//*[contains(@text,'004')]")
	public static WebElement img_inews_tv;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"It seems that you are not connected to the Internet. Check your device's network connection and try again.\"]")
	public static WebElement img_error_connection;
}

