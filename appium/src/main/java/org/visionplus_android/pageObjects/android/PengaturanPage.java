package org.visionplus_android.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.visionplus_android.utils.AndroidGesture;

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
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_signout")
	private WebElement keluarButton;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_dialog_yes")
	private WebElement acceptKeluarButton;
	
	public void SignOut() {
		keluarButton.click();
		acceptKeluarButton.click();
	}
	
}
