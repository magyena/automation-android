package id.visionplus.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import id.visionplus.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LainnyaMenuPage extends AndroidGesture{
	
	AndroidDriver android;
	
	public LainnyaMenuPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btnX")
	 public static WebElement btnXCCare;
	
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_privileges")
	 public static WebElement txtPremiumSportAndPremium;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_title_toolbar")
	 public static WebElement txtSyaratDanKetentuan;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_setting")
	 public static WebElement btnPengaturan;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_package")
	 public static WebElement btnPaket;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_more")
	 public static WebElement btnLainnya;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_term")
	 public static WebElement btnSyaratDanKetentuan;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_faq")
	 public static WebElement btnPertanyaan;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_contact_us")
	 public static WebElement btnHubungiKami;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_ebook")
	 public static WebElement btnEBooks;
	 
	 @AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_paytv")
	 public static WebElement btnBerlangganan;
	 
	 @AndroidFindBy(xpath = "//android.view.View[1]/android.view.View/android.view.View/android.widget.TextView[3]")
	 public static WebElement txtHubungiKami;

	 @AndroidFindBy(xpath = "//android.widget.TabWidget/android.view.View/android.view.View[1]")
	 public static WebElement txtRegistrasi;

	 @AndroidFindBy(xpath = "//android.webkit.WebView//android.view.View[1]//android.widget.TextView[3]")
	 public static WebElement txtHubungiKamiEnglish;

	 @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Premium']")
	 public static WebElement btnPremium;

	 @AndroidFindBy(xpath = "//android.widget.TextView[2]")
	 public static WebElement btnPertanyaanEnglish;
}
