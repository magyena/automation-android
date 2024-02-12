package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VODDetailPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public VODDetailPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/watchButton")
	public static WebElement btn_watch;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/subscribeButton")
	public static WebElement btn_subscribe;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/saveButtonIcon")
	public static WebElement btn_save;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/likeButtonIcon")
	public static WebElement btn_like;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/dislikeButtonIcon")
	public static WebElement btn_dislike;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/backButton")
	public static WebElement btn_back;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/descriptionText")
	public static WebElement txt_content_description;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/title")
	public static WebElement txt_content_title;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/ratingBar")
	public static WebElement img_rating_bar;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Share')]")
	public static WebElement btn_share;
	
	@AndroidFindBy(xpath = "//android.view.View[starts-with(@content-desc,'E1')]")
	public static WebElement img_eps_1_vod;
	
	@AndroidFindBy(xpath = "//android.view.View[starts-with(@content-desc,'E5')]")
	public static WebElement img_eps_5_vod;
}
