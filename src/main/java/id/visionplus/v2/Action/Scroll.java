package id.visionplus.v2.Action;

import org.openqa.selenium.By;
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
	
	public void scrollUntilElementFound(By locator){
		System.out.println("Arrive at scroll until method");
		int flag=0;

		System.out.println("Initiate While Loop");
        while (flag==0) {
            try {
                WebElement element = android.findElement(locator);
                if (element.isDisplayed()) {
            		System.out.println("Element Found");
            		flag=1;
                    break;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
        		System.out.println("Element Not Found, initiate scroll down");
                scrollDown(0.2);
            }
        }
	}
	
	public void scrollDown(double value) {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollDownWithParameter(value);
	}
	
	public void scrollUpNoParameter(double value) {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollUpWithParameter(1);
	}
}
