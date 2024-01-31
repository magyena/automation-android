package id.visionplus.v1.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v1.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TvKuPageVisionPlus extends AndroidGesture
{

	AndroidDriver android;
	WebDriverWait wait;
	
	public TvKuPageVisionPlus(AndroidDriver android) 
	{
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Thumbnail recommendation\"])[25]")
	public static WebElement btnChannelSportStar;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_confirm_cancel")
	public static WebElement btnPopupLogin;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_confirm_oke")
	public static WebElement btnLogin;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_confirm_cancel")
	public static WebElement btnCancelOnPopupLogin;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_confirm_oke")
	public static WebElement btnMasuk;

}

