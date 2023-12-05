package id.visionplus.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.Utils.AndroidGesture;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePageVisionPlus extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public HomePageVisionPlus(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	public WebElement getTextGayaHidup() {
        return android.findElement(By.xpath("//android.widget.TextView[@text='Gaya Hidup & Hobi']"));
    }
	
	public WebElement getBanner() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/iv_presentation"));
    }
	
	public WebElement getTextExploredByCategories() {
        return android.findElement(By.xpath("//android.widget.TextView[@text='Explore By Categories']"));
    }
	
	public WebElement getTextVisionPlusOriginal() {
        return android.findElement(By.xpath("//android.widget.TextView[@text='Vision+ Originals']"));
    }
	
	public WebElement getSearchButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/iv_search"));
    }
	
	public WebElement getRemovePopupSub() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/tv_notification"));
    }
	
	public WebElement getLainnyaButton() {
        return android.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\\\"Lainnya\\\"]"));
    }
	
	public WebElement getSkipButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/tv_skip_intro"));
    }
	
	public WebElement getShowcaseOkButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_showcase_category_oke"));
    }

	public WebElement getShowcaseTvConnectButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/tv_connect"));
    }

	public WebElement getSelengkapnyaButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_see_more"));
    }
	
	public WebElement getClickRandom() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/tv_cluster"));
    }

	public WebElement getBannerHomepage() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/slider_image"));
    }
	
	public WebElement getTextViewSearch() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/lyt_search"));
    }
	
	public WebElement getTextViewSearchInside() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/svSearch"));
    }
	
	public WebElement getTvKuButton() {
        return android.findElement(AppiumBy.accessibilityId("TVku"));
    }
	
	public WebElement getClearButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_clear"));
    }
	
	public WebElement getSignInButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/btn_sign_in"));
    }

	public WebElement getAssertPencarianFalse() {
        return android.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[2]"));
    }
	
	public WebElement getAssertPencarianCorrect() {
        return android.findElement(By.xpath("//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
    }
	
}
