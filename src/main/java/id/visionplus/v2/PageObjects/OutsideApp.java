package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OutsideApp extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public OutsideApp(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(xpath="//*[contains(@text,'Next episode')]")
	public static WebElement btn_next_episode;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"WhatsApp Main Page\"]/android.widget.Image")
	public static WebElement img_whatsApp_logo_header;
	
	@AndroidFindBy(id="com.google.android.gm:id/peoplekit_chip")
	public static WebElement img_gmail_from;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Log In')]")
	public static WebElement btn_login_facebook;
	
	@AndroidFindBy(xpath="//*/android.widget.Button[1]")
	public static WebElement btn_continue_as_facebook;
	

}
