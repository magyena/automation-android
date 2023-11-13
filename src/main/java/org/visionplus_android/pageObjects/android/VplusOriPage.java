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

public class VplusOriPage extends AndroidGesture
{
	AndroidDriver android;
	WebDriverWait wait;
	
	public VplusOriPage(AndroidDriver android) 
	{
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	// Objects
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/image_see_more")
	private WebElement menuVplusOriginalSelengkapnya;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[8]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]")
	private WebElement firstVOD;
	
	
	
	// Actions
	
	public void clickMenuVplusOriginalSelengkapnya() 
	{
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(menuVplusOriginalSelengkapnya));
		menuVplusOriginalSelengkapnya.click();
	}
	
	
	
	public void clickFirstVOD() 
	{
		wait =  new WebDriverWait(android, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(firstVOD));
		firstVOD.click();
	}

}
