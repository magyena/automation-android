package org.visionplus_android.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.visionplus_android.utils.AndroidGesture;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VODPage extends AndroidGesture {

	AndroidDriver android;
	
	public VODPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[3]/android.view.ViewGroup")
	private WebElement moviePremiumOriginalsEps3;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]")
	private WebElement moviePremiumOriginals;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_description")
	private WebElement textErrorSubcriptionPremiumVOD;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_descriptionLimited")
	private WebElement textErrorSubcriptionPremiumLinear;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_title_channel")
	private WebElement textTitleChannelNationalTV;
	
	@AndroidFindBy(xpath="(//android.widget.ImageView[@content-desc=\"Thumbnail recommendation\"])[5]")
	private WebElement btnFreeLinearAntv;
	
	@AndroidFindBy(xpath="(//android.widget.ImageView[@content-desc=\"Thumbnail recommendation\"])[6]")
	private WebElement btnPremiumLinearTransTV;
	
	public void assertTitleChannelNationalTV() {
		String actual = textTitleChannelNationalTV.getText();
		String expected = "Nasional TV";
		
		Assert.assertEquals(actual, expected);
	}
	
	public void assertErrorSubcriptionPremiumLinear() {
		String actual = textErrorSubcriptionPremiumLinear.getText();
		String expected = "Masuk ke akunmu untuk lanjut menonton dan nikmati konten kami di Vision+";
		
		Assert.assertEquals(actual, expected);
	}
	
	public void assertErrorSubcriptionPremiumVOD() {
		String actual = textErrorSubcriptionPremiumVOD.getText();
		String expected = "Masuk ke akunmu untuk lanjut menonton dan nikmati konten kami di Vision+";
		
		Assert.assertEquals(actual, expected);
	}
	
	public void clickBtnPremiumLinearTransTV() {
		btnPremiumLinearTransTV.click();
	}
	
	public void clickBtnFreeLinearAntv() {
		btnFreeLinearAntv.click();
	}
	
	public void clickEps3VOD() {
		moviePremiumOriginalsEps3.click();
	}
	
	public void clickPremiumVOD() {
		moviePremiumOriginals.click();
	}
}
