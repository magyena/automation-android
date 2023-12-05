package id.visionplus.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VplusOriPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public VplusOriPage(AndroidDriver android) 
	{
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	public WebElement getMenuVplusOriginalSelengkapnya() {
        return android.findElement(By.id("com.zte.iptvclient.android.idmnc:id/image_see_more"));
    }

	public WebElement getFirstVOD() {
        return android.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[8]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]"));
    }


}
