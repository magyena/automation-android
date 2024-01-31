package id.visionplus.v1.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v1.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuHeaderPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public MenuHeaderPage(AndroidDriver android) 
	{
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='V+ Originals']/android.widget.TextView")
    public static WebElement txtMenuHeaderVPlusOriginal;
}
