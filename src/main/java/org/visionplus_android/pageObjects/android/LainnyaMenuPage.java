package org.visionplus_android.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.visionplus_android.utils.AndroidGesture;

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
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_setting")
	private WebElement pengaturanButton;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/linear_action_package")
	private WebElement paketButton;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_privileges")
	private WebElement textPremiumSportAndPremium;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc=\"Premium\"]")
	private WebElement btnTextPremium;
	
	public void assertTextPremiumSport() {
		String actual = textPremiumSportAndPremium.getText();
		String expected = "V+ PREMIUM SPORTS PRIVILEGES";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextPremium() {
		String actual = textPremiumSportAndPremium.getText();
		String expected = "V+ PREMIUM PRIVILEGES";
		Assert.assertEquals(actual, expected);
	}
	
	public void clickBtnTextPremium() {
		btnTextPremium.click();
	}
	
	public void clickPaketButton() {
		paketButton.click();
	}
	
	public void pengaturanLainnya() {
		pengaturanButton.click();
	}

}
