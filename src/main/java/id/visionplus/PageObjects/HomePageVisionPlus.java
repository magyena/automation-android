package id.visionplus.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.Utils.AndroidGesture;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
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
	
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_notification") 
	 public static WebElement imgBuyPkgNotif;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/layout_popup_notif") 
	 public static WebElement layoutPopUpNotif;
	
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_skip_intro") 
	 public static WebElement btnSkip;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_connect") 
	 public static WebElement btnShowcaseTvConnect;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_showcase_category_oke")
	 public static WebElement btnShowCaseOK;
		
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/iv_presentation")
	 public static WebElement btnBanner;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/iv_search")
	 public static WebElement btnSearch;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_notification")
	 public static WebElement removePopUpSub;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_see_more")
	 public static WebElement btnSelengkapnya;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_cluster")
	 public static WebElement btnRandom;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/slider_image")
	 public static WebElement btnBannerHomepage;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/lyt_search")
	 public static WebElement txtViewSearch;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/svSearch")
	 public static WebElement txtViewSearchInside;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_clear")
	 public static WebElement btnClear;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_sign_in")
	 public static WebElement btnSignIn;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/bottom_mylist")
	 public static WebElement btnSport;
	 
	 @AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Lainnya\"]")
	 public static WebElement btnMenuLainnya;
	 
	 @AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc=\"V+ Originals\"]/android.widget.TextView")
	 public static WebElement btnVplusOriginal;
	 
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='Gaya Hidup & Hobi']")
	 public static WebElement txtGayaHidup;
	
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='Explore By Categories']")
	 public static WebElement txtExploredByCategories;
	
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='Vision+ Originals']")
	 public static WebElement txtVisionPlusOriginal;
	 
	 @AndroidFindBy(xpath="//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	 public static WebElement txtAssertPencarianCorrect;
	 
	 @AndroidFindBy(xpath="//android.view.ViewGroup/android.widget.TextView[2]")
	 public static WebElement txtAssertPencarianFalse;
		
	 @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.widget.Button[1]") 
	 public static WebElement btnCloseAds;
	 
	 @AndroidFindBy(xpath="//android.view.View[@content-desc=\"X\"]/android.widget.TextView") 
	 public static WebElement btnCloseBottomAds;
	 	
	public WebElement getTvKuButton() {
        return android.findElement(AppiumBy.accessibilityId("TVku"));
    }
	
}
