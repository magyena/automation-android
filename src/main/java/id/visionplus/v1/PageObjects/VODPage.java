package id.visionplus.v1.PageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v1.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VODPage extends AndroidGesture {

	AndroidDriver android;
	WebDriverWait wait;
	
	public VODPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/tv_descriptionLimited")
	public static WebElement txtErrorSubcriptionPremiumVOD;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/tv_descriptionLimited")
	public static WebElement txtErrorSubcriptionPremiumLinear;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/tv_title_channel")
	public static WebElement txtTitleChannelNationalTV;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup")
	public static WebElement btnMoviePremiumOriginalEps3;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup")
	public static WebElement btnMoviePremiumOriginalEps1;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]")
	public static WebElement btnMoviePremiumOriginal;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Thumbnail recommendation\"])[5]")
	public static WebElement btnFreeLinearAntv;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Thumbnail recommendation\"])[6]")
	public static WebElement btnPremiumLinearTransTv;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btnScreenCast")
	public static WebElement btnChromeCast;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btnScreenCast")
	public static WebElement btnDataSaver;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_schedule")
	public static WebElement btnSchedule;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout")
	public static WebElement btnScheduleCatchup;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_watchlist")
	public static WebElement btnWatchList;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_download")
	public static WebElement btnDownload;

}
