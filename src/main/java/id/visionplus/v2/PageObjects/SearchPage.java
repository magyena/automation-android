package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public SearchPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/errorTextView")
	public static WebElement txt_warning_not_found;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/search_edit_text")
	public static WebElement txt_fld_search;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Arab Maklum\"]")
	public static WebElement img_search_vod_arab_maklum;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[contains(@text, 'Channels')]/following::*[@content-desc='RCTI'])[2]")
	public static WebElement img_search_live_tv_rcti;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Cinta Di Balik Awan\"]")
	public static WebElement vod_cinta_di_balik_awan;
	

}