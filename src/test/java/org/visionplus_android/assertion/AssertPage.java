package org.visionplus_android.assertion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.visionplus_android.utils.AndroidGesture;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AssertPage extends AndroidGesture{
	
	AndroidDriver android;
	
	public AssertPage(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/et_phone")
	private WebElement editTextPhone;
	
	
	@AndroidFindBy(id="com.zte.iptvclient.android.idmnc:id/btn_register")
	private WebElement btnLoginEmail;
	
	public void assert_LoginPageShouldBeDisplayed() throws InterruptedException 
	{
	
		Thread.sleep(3000);
		boolean isEditTextPhoneExist = editTextPhone.isDisplayed();
		
		boolean isBtnLoginEmail = btnLoginEmail.isDisplayed();
		
		Assert.assertTrue(isEditTextPhoneExist);
		Assert.assertTrue(isBtnLoginEmail);
	}
	
	
}
