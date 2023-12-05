package id.visionplus.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TvKUPageVisionPlus extends AndroidGesture
{

	AndroidDriver android;
	WebDriverWait wait;
	
	public TvKUPageVisionPlus(AndroidDriver android) 
	{
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	public WebElement getChannelSportStarButton() {
        return android.findElement(By.xpath("//android.widget.ImageView[@content-desc=\\\"Thumbnail recommendation\\\"])[25]"));
    }

	public WebElement getPopupLogin() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_confirm_cancel"));
    }

	public WebElement getLoginButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_confirm_oke"));
    }

	public WebElement getCancelOnPopupLoginButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_confirm_cancel"));
    }

	public WebElement getMasukButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_confirm_oke"));
    }
}

