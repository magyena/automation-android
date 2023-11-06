package org.visionplus_android.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.visionplus_android.utils.AndroidGesture;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuFooterPage extends AndroidGesture
{
	AndroidDriver android;
	
	public MenuFooterPage(AndroidDriver android) 
	{
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Beranda\"]/android.widget.ImageView")
	private WebElement menuBeranda;
	
	
	public void clickMenuBeranda() {
		menuBeranda.click();
	}
	
}
