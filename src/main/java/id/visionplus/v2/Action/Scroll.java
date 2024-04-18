package id.visionplus.v2.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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
	    System.out.println("Arrive at scroll down until");
	    int flag = 0;
	    long startTime = System.currentTimeMillis();
	    long timeoutInMillis = TimeUnit.SECONDS.toMillis(90); // Timeout set to 180 seconds

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
	    	scrollUpUntilElementFound(locator);
	        System.out.println("Element not found within the timeout period.");
	        // You might want to throw an exception or handle the failure in some way here
	    }
	}
	
	public void scrollUpUntilElementFound(By locator) {
	    System.out.println("Arrive at scroll Up until");
	    int flag = 0;
	    long startTime = System.currentTimeMillis();
	    long timeoutInMillis = TimeUnit.SECONDS.toMillis(180); // Timeout set to 180 seconds

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
	            scrollUp(0.2);
	        }
	    }

	    if (flag == 0) {
	        System.out.println("Element not found within the timeout period.");
	        // You might want to throw an exception or handle the failure in some way here
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
