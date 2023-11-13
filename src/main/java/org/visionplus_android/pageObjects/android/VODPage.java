package org.visionplus_android.pageObjects.android;


import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.visionplus_android.utils.AndroidGesture;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VODPage extends AndroidGesture {

	AndroidDriver android;
	WebDriverWait wait;
	
	public VODPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[3]/android.view.ViewGroup")
	private WebElement moviePremiumOriginalsEps3;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[1]/android.view.ViewGroup")
	private WebElement moviePremiumOriginalsEps1;
	
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
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btnScreenCast")
	private WebElement btnChromeCast;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/exo_data_saver_off")
	private WebElement btnDataSaver;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_schedule")
	private WebElement btnSchedule;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.LinearLayout")
	private WebElement btnScheduleCatchup;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_watchlist")
	private WebElement btnWatchList;
	

	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_download")
	private WebElement btnDownload;
	
	
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
	
	public void assertErrorChooseSchedule() {
		String actual = textErrorSubcriptionPremiumLinear.getText();
		String expected = "Silakan login untuk melanjutkan nonton dan nikmati konten di Vision+";
		
		Assert.assertEquals(actual, expected);
	}
	
	public void assertErrorSubcriptionPremiumVOD() {
		String actual = textErrorSubcriptionPremiumVOD.getText();
		String expected = "Masuk ke akunmu untuk lanjut menonton dan nikmati konten kami di Vision+";
		
		Assert.assertEquals(actual, expected);
	}
	
	public void clickBtnScheduleCatchup() {
		btnScheduleCatchup.click();
	}
	
	public void clickBtnSchedule() {
		btnSchedule.click();
	}
	
	public void clickBtnDataSaver() {
		btnDataSaver.click();
	}
	
	public void clickBtnChromeCast() {
		btnChromeCast.click();
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
	
	public void clickEps1VOD() {
		moviePremiumOriginalsEps1.click();
	}
	
	public void clickPremiumVOD() {
		moviePremiumOriginals.click();
	}
	
	public void clickWatchList() {
		
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(btnWatchList));
        btnWatchList.click();
	}
	
	
	public void clickDownload() {
		
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(btnDownload));
		btnDownload.click();
	}
}
