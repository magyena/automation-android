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

	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.zte.iptvclient.android.idmnc:id/templateGrid\"]/android.view.View[2]")
	public static WebElement coming_soon_vod_1; 

	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.zte.iptvclient.android.idmnc:id/templateGrid\"]/android.view.View[3]")
	public static WebElement coming_soon_vod_2; 
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.zte.iptvclient.android.idmnc:id/templateGrid\"]/android.view.View[4]")
	public static WebElement coming_soon_vod_3; 
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Twisted 3: The Sinners\"]")
	public static WebElement img_sinners; 
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Radio\"]")
	public static WebElement img_radio; 
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"12 Hari\"]")
	public static WebElement img_12Hari; 
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Prince Of My Heart\"]")
	public static WebElement img_prince;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Piknik Pesona\"]")
	public static WebElement img_piknik;

	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Katanya\"]")
	public static WebElement img_katanya;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Ada Dewa Disisiku\"]")
	public static WebElement img_Ada_dewa;

	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Catatan Akhir Sekolah: The Series\"]")
	public static WebElement img_catatan_akhir_sekolah;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"My Comic Boyfriend\"]")
	public static WebElement img_comic;

	
	
	

	
	
	
	
	
	
	
	
}
