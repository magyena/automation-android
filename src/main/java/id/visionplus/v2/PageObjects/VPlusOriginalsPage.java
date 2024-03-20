package id.visionplus.v2.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VPlusOriginalsPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public VPlusOriginalsPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"CinLock - Love, Camera, Action!\"]")
	public static WebElement img_cinlock;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.View[1]")
	public static WebElement img_vod_1;
	
	@AndroidFindBy(xpath="(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.zte.iptvclient.android.idmnc:id/stripRecyclerView\"])[2]/android.view.View[1]")
	public static WebElement sample_vod; //inno
	
	@AndroidFindBy(xpath="com.zte.iptvclient.android.idmnc:id/media_player_title_textview")
	public static WebElement txt_Vod_Play; //inno
	
	
	
}
