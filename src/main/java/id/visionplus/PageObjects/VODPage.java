package id.visionplus.PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VODPage extends AndroidGesture {

	AndroidDriver android;
	WebDriverWait wait;
	
	public VODPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	public WebElement getTextErrorSubcriptionPremiumVOD() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/tv_descriptionLimited"));
    }
	
	public WebElement getTextErrorSubcriptionPremiumLinear() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/tv_descriptionLimited"));
    }
	
	public WebElement getTextTitleChannelNationalTV() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/tv_title_channel"));
    }
	
	public WebElement getMoviePremiumOriginalEps3() {
        return android.findElement(By.xpath("//android.view.ViewGroup[3]/android.view.ViewGroup"));
    }

	public WebElement getMoviePremiumOriginalEps1() {
        return android.findElement(By.xpath("//android.view.ViewGroup[1]/android.view.ViewGroup"));
    }

	public WebElement getMoviePremiumOriginal() {
        return android.findElement(By.xpath("//android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]"));
    }

	public WebElement getFreeLinearAntvButton() {
        return android.findElement(By.xpath("//android.widget.ImageView[@content-desc=\\\"Thumbnail recommendation\\\"])[5]"));
    }

	public WebElement getPremiumLinearTransTvButton() {
        return android.findElement(By.xpath("//android.widget.ImageView[@content-desc=\\\"Thumbnail recommendation\\\"])[6]"));
    }

	public WebElement getChromeCastButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btnScreenCast"));
    }

	public WebElement getDataSaverButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btnScreenCast"));
    }

	public WebElement getScheduleButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_schedule"));
    }

	public WebElement getScheduleCatchup() {
        return android.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.LinearLayout"));
    }

	public WebElement getWatchListButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_watchlist"));
    }

	public WebElement getDownloadButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_download"));
    }
}
