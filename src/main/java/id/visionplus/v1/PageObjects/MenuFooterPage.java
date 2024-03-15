package id.visionplus.v1.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import id.visionplus.v1.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuFooterPage extends AndroidGesture {
	AndroidDriver android;

	public MenuFooterPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Beranda']/android.widget.ImageView")
	public static WebElement imgMenuBeranda;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='TVku']/android.widget.ImageView")
	public static WebElement imgTvKu;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/view_game")
	public static WebElement imgGamesPlus;
	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/menuButton")
	public static WebElement btnHome;

}
