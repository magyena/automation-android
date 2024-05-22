package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class EuroPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public EuroPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='EURO Official Film']") 
	 public static WebElement txt_Euro_official_film;
	
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='Teams']") 
	 public static WebElement txt_Teams;
}
