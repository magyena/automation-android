package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProgramGuidePage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public ProgramGuidePage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	@AndroidFindBy(xpath ="//android.widget.TextView[@text=\"Channel list\"]" )
	public static WebElement txt_program_guide_1; //inno

	@AndroidFindBy(xpath ="(//android.widget.LinearLayout[@resource-id=\"com.zte.iptvclient.android.idmnc:id/baseEventView\"])[4]" )
	public static WebElement disable_guide4; //inno
	
	@AndroidFindBy(xpath ="(//android.widget.LinearLayout[@resource-id=\"com.zte.iptvclient.android.idmnc:id/baseEventView\"])[3]" )
	public static WebElement disable_guide3; //inno

	@AndroidFindBy(id ="com.zte.iptvclient.android.idmnc:id/watchButton" )
	public static WebElement btn_watch; //inno
	
	@AndroidFindBy(id ="com.zte.iptvclient.android.idmnc:id/menuButton" )
	public static WebElement btn_back; //inno
	

	
}

