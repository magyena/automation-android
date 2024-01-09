package id.visionplus.Action;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.MainFunction.BaseTest;
import id.visionplus.PageObjects.LoginPageVisionPlus;
import io.appium.java_client.android.AndroidDriver;

public class Input extends BaseTest
{
	WebDriverWait wait;
	LoginPageVisionPlus loginPage;
	
	Click click = new Click();

	public void inputPhoneNumber(String phoneNumber) {
	    loginPage = new LoginPageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement phoneButton = loginPage.btnWithPhone;
	 
	    wait.until(ExpectedConditions.visibilityOfAllElements(phoneButton));
	    phoneButton.click();
	   
	    WebElement phoneNumberTextBox = loginPage.txtEditTextPhone;
	    wait.until(ExpectedConditions.visibilityOfAllElements(phoneNumberTextBox));
	    phoneNumberTextBox.sendKeys(phoneNumber);
	}

	public void inputPhonePassword(String phonePassword) {
	    loginPage = new LoginPageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement passwordTextBox = loginPage.txtPasswordPhoneTextBox;
	    wait.until(ExpectedConditions.visibilityOfAllElements(passwordTextBox));
	    passwordTextBox.click();
	    passwordTextBox.sendKeys(phonePassword);
	}

	public void inputOtp1(String otp1) {
	    loginPage = new LoginPageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));

	    WebElement inputOtpField1 = loginPage.txtInputOtp1;
	    wait.until(ExpectedConditions.visibilityOfAllElements(inputOtpField1));
	    inputOtpField1.click();
	    inputOtpField1.sendKeys(otp1);
	}

	public void inputOtp2(String otp2) {
	    loginPage = new LoginPageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement inputOtpField2 = loginPage.txtInputOtp2;
	    wait.until(ExpectedConditions.visibilityOfAllElements(inputOtpField2));
	    inputOtpField2.click();
	    inputOtpField2.sendKeys(otp2);
	}

	public void inputOtp3(String otp3) {
	    loginPage = new LoginPageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement inputOtpField3 = loginPage.txtInputOtp3;
	    wait.until(ExpectedConditions.visibilityOfAllElements(inputOtpField3));
	    inputOtpField3.click();
	    inputOtpField3.sendKeys(otp3);
	}

	public void inputOtp4(String otp4) {
	    loginPage = new LoginPageVisionPlus(android);
	    wait = new WebDriverWait(android, Duration.ofSeconds(60));
	    WebElement inputOtpField4 = loginPage.txtInputOtp4;
	    wait.until(ExpectedConditions.visibilityOfAllElements(inputOtpField4));
	    inputOtpField4.click();
	    inputOtpField4.sendKeys(otp4);
	}

}
