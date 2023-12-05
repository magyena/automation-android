package id.visionplus.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import id.visionplus.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LainnyaMenuPage extends AndroidGesture{
	
	AndroidDriver android;
	
	public LainnyaMenuPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	public WebElement getTextPremiumSportAndPremium() {
		return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/tv_privileges"));
	}
	
	public WebElement getTextSyaratDanKetentuan() {
		return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/tv_title_toolbar"));
	}
	
	public WebElement getTextHubungiKami() {
		return android.findElement(By.xpath("//android.view.View[1]/android.view.View/android.view.View/android.widget.TextView[3]"));
	}
	
	public WebElement getTextRegistrasi() {
		return android.findElement(By.xpath("//android.widget.TabWidget/android.view.View/android.view.View[1]"));
	}
	
	public WebElement getTextHubungiKamiEnglish() {
		return android.findElement(By.xpath("//android.view.View[1]/android.view.View/android.view.View/android.widget.TextView[3]"));
	}
	
	public WebElement getPengaturanButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/linear_action_setting"));
    }
	
	public WebElement getPaketButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/linear_action_package"));
    }
	
	public WebElement getLainnyaButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/linear_action_more"));
    }
	
	public WebElement getSyaratDanKetentuanButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/linear_action_term"));
    }
	
	public WebElement getPertanyaanButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/linear_action_faq"));
    }

	public WebElement getTextPremiumButton() {
        return android.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\\\"Premium\\\"]"));
    }
	
	public WebElement getHubungiKamiButton() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/linear_action_contact_us"));
    }
	
	public WebElement getPertanyaanEnglishButton() {
        return android.findElement(By.xpath("//android.widget.TextView[2]"));
    }

}
