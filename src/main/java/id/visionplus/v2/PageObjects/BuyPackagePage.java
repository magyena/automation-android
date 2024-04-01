package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class BuyPackagePage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public BuyPackagePage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	 @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Rp 35.000,00\"]") 
	 public static WebElement txt_package_premiumsports30_days;
	 
	 @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/text_view_separator_title\" and @text=\"Your current package\"]") 
	 public static WebElement txt_package_page;
	
	 @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\" and @text=\"Error\"]") 
	 public static WebElement txt_error_subscription;
	 
	 @AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\"]")
	public static WebElement error_message_cantbuy;
	
	
	 
	
}
