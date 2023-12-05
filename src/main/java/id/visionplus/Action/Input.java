package id.visionplus.Action;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.PageObjects.LoginPageVisionPlus;
import io.appium.java_client.android.AndroidDriver;

public class Input
{

	AndroidDriver android;
	WebDriverWait wait;
	LoginPageVisionPlus loginPage;
	
	public Input(AndroidDriver android) {
		this.android = android;
		loginPage = new LoginPageVisionPlus(android);
	}
	
	Click click = new Click(android);

	public void inputPhoneNumber(String phoneNumber) {
		loginPage.getWithPhone().click();
		loginPage.getWithPhone().sendKeys(phoneNumber);
	}
	
	public void inputPhonePassword(String phonePassword) {
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement passwordTextBox = loginPage.getPasswordPhoneTextBox();
		wait.until(ExpectedConditions.visibilityOfAllElements(passwordTextBox));
		passwordTextBox.click();
		passwordTextBox.sendKeys(phonePassword);
	}
	
	public void inputOtp1(String otp1)
	{
		wait =  new WebDriverWait(android, Duration.ofSeconds(60));
		WebElement inputOtpField1 = loginPage.getInputOtp1();
		wait.until(ExpectedConditions.visibilityOfAllElements(inputOtpField1));
		inputOtpField1.click();
		inputOtpField1.sendKeys(otp1);
	}
	
	public void inputOtp2(String otp2)
	{
		WebElement inputOtpField2 = loginPage.getInputOtp2();
		wait.until(ExpectedConditions.visibilityOfAllElements(inputOtpField2));
		inputOtpField2.click();
		inputOtpField2.sendKeys(otp2);
	}
	
	public void inputOtp3(String otp3)
	{
		WebElement inputOtpField3 = loginPage.getInputOtp3();
		wait.until(ExpectedConditions.visibilityOfAllElements(inputOtpField3));
		inputOtpField3.click();
		inputOtpField3.sendKeys(otp3);
	}
	
	public void inputOtp4(String otp4)
	{
		WebElement inputOtpField4 = loginPage.getInputOtp4();
		wait.until(ExpectedConditions.visibilityOfAllElements(inputOtpField4));
		inputOtpField4.click();
		inputOtpField4.sendKeys(otp4);
	}
}
