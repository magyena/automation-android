package id.visionplus.v2.Action;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Scroll extends AndroidGesture
{

	AndroidDriver android;
	WebDriverWait wait;
	
	public Scroll(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	public void scrollToText(String text) {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollToText(text);
	}
	
	public void scrollUntilElementFound(By locator) {
	    int flag = 0;
	    long startTime = System.currentTimeMillis();
	    long timeoutInMillis = TimeUnit.SECONDS.toMillis(180);

	    while (flag == 0 && System.currentTimeMillis() - startTime <= timeoutInMillis) {
	        try {
	            WebElement element = android.findElement(locator);
	            if (element.isDisplayed()) {
	                System.out.println("Element Found");
	                flag = 1;
	                break;
	            }
	        } catch (NoSuchElementException e) {
	            System.out.println("Element Not Found, initiate scroll down");
	            scrollDown(0.2);
	            scrollUp(0.3);
	        }
	    }

	    if (flag == 0) {
	        System.out.println("Element not found within the timeout period.");
	    }
	}
	
	public void scrollDown(double value) {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollDownWithParameter(value);
	}
	
	public void scrollUp(double value) {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollUpWithParameter(value);
	}
}
