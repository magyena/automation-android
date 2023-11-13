package org.visionplus_android.pageObjects.android;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.visionplus_android.utils.AndroidGesture;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuHeaderPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public MenuHeaderPage(AndroidDriver android) 
	{
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc=\"V+ Originals\"]/android.widget.TextView")
	private WebElement menuHeaderVPlusOriginal;
	
	
	public void clickMenuVplusOriginal() 
	{
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(menuHeaderVPlusOriginal));
		menuHeaderVPlusOriginal.click();
	}
	
}
