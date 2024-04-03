package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PopUpPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public PopUpPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/other_showings_group_header_title")
	public static WebElement txt_pop_up_header_title;
	
	@AndroidFindBy(xpath="//*[starts-with(@content-desc,'Premium')]")
	public static WebElement txt_package_premium;
	
	@AndroidFindBy(xpath="//*[starts-with(@content-desc,'Premium' Sports)]")
	public static WebElement txt_package_premium_sport;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/popup_element_title\" and @text=\"Premium 30 days\"]")
	public static WebElement txt_package_premium30days;
	
	
	@AndroidFindBy(id="android:id/button1")
	public static WebElement txt_profiles_have_been_deleted;
	
	
	
	
	
	
}
