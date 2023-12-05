package id.visionplus.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import id.visionplus.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuFooterPage extends AndroidGesture
{
	AndroidDriver android;
	
	public MenuFooterPage(AndroidDriver android) 
	{
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	public WebElement getMenuBeranda() {
        return android.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\\\"Beranda\\\"]/android.widget.ImageView"));
    }
	
	public WebElement getTvKu() {
        return android.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\\\"TVku\\\"]/android.widget.ImageView"));
    }
	
}
