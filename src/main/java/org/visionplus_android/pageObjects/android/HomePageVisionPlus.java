package org.visionplus_android.pageObjects.android;

import java.sql.Time;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.visionplus_android.utils.AndroidGesture;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePageVisionPlus extends AndroidGesture{

	AndroidDriver android;
	WebDriverWait wait;

	
	public HomePageVisionPlus(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);

	}
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/iv_search")
	private WebElement btnSearch;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_notification")
	private WebElement removePopupSub;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Lainnya\"]")
	private WebElement lainnyaButton;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_skip_intro")
	private WebElement skipButton;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_showcase_category_oke")
	private WebElement btnShowcaseOk;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_connect")
	private WebElement btnShowcaseTvConnect;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Gaya Hidup & Hobi']")
	private WebElement textGayaHidup;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/iv_presentation")
	private WebElement banner;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_see_more")
	private WebElement btnSelengkapnya;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/tv_cluster")
	private WebElement clickRandom;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Explore By Categories']")
	private WebElement textExploreByCategories;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Vision+ Originals']")
	private WebElement textVisionPlusOriginal;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/slider_image")
	private WebElement bannerHomepage;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/lyt_search")
	private WebElement textviewSearch;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/svSearch")
	private WebElement textviewSearchInside;
	
	@AndroidFindBy(accessibility="TVku")
	private WebElement btnTVku;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_clear")
	private WebElement btnClear;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.widget.TextView[2]")
	private WebElement assertPencarianFalse;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	private WebElement assertPencarianCorrect;
	
	public void assertTextPencarianFalse() {
		String actual = assertPencarianFalse.getText();
		String expected = "Pencarian Populer";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextPencarianCorrect() {
		String actual = assertPencarianCorrect.getText();
		String expected = "Film & TV";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextExploreByCategories() {
		String actual = textExploreByCategories.getText();
		String expected = "Explore By Categories";
		Assert.assertEquals(actual, expected);
	}
	
	public void assertTextVisionPlusOriginal() {
		String actual = textVisionPlusOriginal.getText();
		String expected = "Vision+ Originals";
		Assert.assertEquals(actual, expected);
	}
	
	public void clickBtnClear() {
		btnClear.click();
	}
	
	public void clickTextViewSearchCorrect(String input) {
		textviewSearch.click();
		textviewSearchInside.sendKeys(input);
		((AndroidDriver) android).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	public void clickTextViewSearchFalse(String input) {
		textviewSearch.click();
		textviewSearchInside.sendKeys(input);
		((AndroidDriver) android).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	public void clickBtnSearch() {
		btnSearch.click();
	}
	
	public void clickBtnTVku() {
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		btnTVku.click();
	}
	
	public void clickBtnShowcaseTvConnect() {
		btnShowcaseTvConnect.click();
	}
	
	public void clickBtnSelengkapnya() {
		btnSelengkapnya.click();
	}
	
	public void clickBanner() {
		bannerHomepage.click();
	}
	
	public void swipeBannerLeft() {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.swipeLeftNoParameter();
	}
	
	public void swipeBannerRight() {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.swipeRightNoParameter();
	}
	
	
	public void scrollToText(String text) {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollToText(text);
	}
	
	public void scrollDown(double value) {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollDownWithParameter(value);
	}
	
	public void scrollUpNoParameter(double value) {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollUpWithParameter(1);
	}
	
	public void clickBtnShowcaseOk() {
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(btnShowcaseOk));

		btnShowcaseOk.click();
	}
	
	public void removePopupSub() {
		removePopupSub.click();
	}
	
	public void lainnyaButton() {
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(lainnyaButton));
		lainnyaButton.click();
	}
	
	public void lewatiButton() 
	{
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		skipButton.click();
	}
	
}
