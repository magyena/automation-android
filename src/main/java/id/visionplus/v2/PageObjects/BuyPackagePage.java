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
	 @AndroidFindBy(xpath="//android.view.View[@content-desc='Rp 40.000,00']") 
	 public static WebElement txt_package_premiumsports30_days;
	 
	 @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/text_view_separator_title\" and @text=\"Your current package\"]") 
	 public static WebElement txt_package_page;
	
	 @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\" and @text=\"Error\"]") 
	 public static WebElement txt_error_subscription;
	 
	 @AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\"]")
	 public static WebElement error_message_cantbuy;
	
	 @AndroidFindBy(xpath="(//android.view.View[@content-desc=\"30 days left\"])[1]")
	 public static WebElement txt_premium30_package;
		
	 @AndroidFindBy(xpath="(//android.view.View[@content-desc=\"30 days left\"])[2]")
	 public static WebElement txt_premium30Sports_package;
	
	 @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Rp 79.000,00\"]")
	 public static WebElement txt_package_euro;
	
	 @AndroidFindBy(xpath="//android.view.View[substring(@content-desc, string-length(@content-desc) - string-length('days left') + 1) = 'days left']")
	 public static WebElement txt_current_package_euro;
	
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='Packages']/following::android.view.View[1]")
		public static WebElement euro_package;
	
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='Your current package']/following::android.view.View[2]")
		public static WebElement current_euro_package;
}
