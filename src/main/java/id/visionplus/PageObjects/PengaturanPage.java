package id.visionplus.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import id.visionplus.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PengaturanPage extends AndroidGesture {

    AndroidDriver android;
	
	public PengaturanPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/linear_action_signout")
	public static WebElement btnKeluar;

	@AndroidFindBy(id = "com.zte.iptvclient.android.idmnc:id/btn_dialog_yes")
	public static WebElement btnAcceptKeluar;

}
