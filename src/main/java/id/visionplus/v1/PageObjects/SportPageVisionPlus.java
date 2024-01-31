package id.visionplus.v1.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v1.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SportPageVisionPlus extends AndroidGesture
{

	AndroidDriver android;
	WebDriverWait wait;
	
	public SportPageVisionPlus(AndroidDriver android) 
	{
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Thumbnail recommendation\"])[5]")
	public static WebElement imgAiringTodayTv;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.widget.TextView")
	public static WebElement imgSportPageAds;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.widget.Button[1]")
	public static WebElement exitSportPageAds;
	
	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_play")
	public static WebElement btnPlay;

}

