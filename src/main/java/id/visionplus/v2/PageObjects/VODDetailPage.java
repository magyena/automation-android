package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VODDetailPage extends AndroidGesture {
	AndroidDriver android;
	WebDriverWait wait;

	public VODDetailPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/startDownloadButton")
	public static WebElement btn_download;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/watchButton")
	public static WebElement btn_watch;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/subscribeButton")
	public static WebElement btn_subscribe;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/saveButtonIcon")
	public static WebElement btn_save;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/likeButtonIcon")
	public static WebElement btn_like;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/dislikeButtonIcon")
	public static WebElement btn_dislike;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/backButton")
	public static WebElement btn_back;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/descriptionText")
	public static WebElement txt_content_description;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/title")
	public static WebElement txt_content_title;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/ratingBar")
	public static WebElement img_rating_bar;

	@AndroidFindBy(id = "android:id/chooser_copy_button")
	public static WebElement btn_copy_link;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/trailerButton")
	public static WebElement btn_trailer;

	@AndroidFindBy(xpath = "//*[contains(@text,'Gmail')]")
	public static WebElement txt_share_gmail;

	@AndroidFindBy(xpath = "//*[contains(@text,'Messages')]")
	public static WebElement txt_share_messages;

	@AndroidFindBy(xpath = "//*[contains(@text,'Drive')]")
	public static WebElement txt_share_drive;

	@AndroidFindBy(xpath = "//*[contains(@text,'Bluetooth')]")
	public static WebElement txt_share_bluetooth;

	@AndroidFindBy(xpath = "//*[contains(@text,'Share')]")
	public static WebElement btn_share;

	@AndroidFindBy(xpath = "//android.view.View[starts-with(@content-desc,'E1')]")
	public static WebElement img_eps_1_vod;

	@AndroidFindBy(xpath = "//android.view.View[starts-with(@content-desc,'E2')]")
	public static WebElement txt_eps_2_vod;

	@AndroidFindBy(xpath = "//android.view.View[starts-with(@content-desc,'E')][last()]")
	public static WebElement img_eps_premium_vod;

	@AndroidFindBy(xpath = "//*[contains(@text,'The One')]")
	public static WebElement sample_the_one; // inno

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"E1 The One that Got Away\"]")
	public static WebElement sample_the_one_eps1; // inno

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/seriesTitle")
	public static WebElement series_tittle_eps1; // inno

	@AndroidFindBy(id = "android:id/button1")
	public static WebElement btn_confirm_download; // inno

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/progressBarDownloaded")
	public static WebElement btn_cancel_download; // inno
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/alertTitle")
	public static WebElement txt_confirm_download;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"WhatsApp\"]")
	public static WebElement btn_share_Wa; // inno

	@AndroidFindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"com.whatsapp:id/contactpicker_text_container\"])[4]")
	public static WebElement btn_share_Wa_Number; // inno

	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Download\"]")
	public static WebElement body_details_VOD; // inno
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Remove from List')]")
	public static WebElement txt_Remove_from_list;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Add to List')]")
	public static WebElement txt_Add_to_list;
}

