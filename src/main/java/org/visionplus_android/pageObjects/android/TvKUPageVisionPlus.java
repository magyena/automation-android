package org.visionplus_android.pageObjects.android;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.visionplus_android.utils.AndroidGesture;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TvKUPageVisionPlus extends AndroidGesture
{

	AndroidDriver android;
	WebDriverWait wait;
	
	public TvKUPageVisionPlus(AndroidDriver android) 
	{
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	@AndroidFindBy(xpath="(//android.widget.ImageView[@content-desc=\"Thumbnail recommendation\"])[25]")
	private WebElement btnChannelSportStar;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/layoutBoxLimited")
	private WebElement popupLogin;
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_confirm_oke")
	private WebElement buttonLogin;
	
	
	@AndroidFindBy(id ="com.zte.iptvclient.android.idmnc:id/btn_confirm_cancel")
	private WebElement btnCancelOnPopupLogin;
	
	public void clickSportStar() {
		
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(btnChannelSportStar));
        btnChannelSportStar.click();
	}
	
	public void scrollDown(double value) {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollDownWithParameter(value);
	}
	
	
	public void assertPopupLogin()
	{

		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(popupLogin));
		
		Boolean isPopupPresent =  popupLogin.isDisplayed();
		
		Assert.assertTrue(isPopupPresent);
	}
	
	public void assertLogin()
	{
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(buttonLogin));
		
		Boolean isBtnLoginPresent =  buttonLogin.isDisplayed();
		
		Assert.assertTrue(isBtnLoginPresent);
	}
	
	
	public void clickCancelLogin() {
		
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(btnChannelSportStar));
        btnChannelSportStar.click();
	}
	
}

