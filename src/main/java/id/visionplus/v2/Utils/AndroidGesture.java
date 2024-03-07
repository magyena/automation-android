package id.visionplus.v2.Utils;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidGesture extends AppiumUtils {
	
	AndroidDriver android;
	
	public AndroidGesture(AndroidDriver android) {
		super(android);
		this.android = android;
	}
	
	public void scrollToText(String text) {
		android.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
	}
	
	//semakin kecil double value scroll semakin jauh
	//note scroll from 0.1 - 1.0
	public void scrollDownWithParameter(double value) {
		Dimension size = android.manage().window().getSize();
	    int startX = size.getWidth() / 2;
	    
		//semakin kecil double value scroll semakin jauh
	    int startY = size.getHeight() / 2;
	    
	    int endX = startX;
	    int endY = (int) (size.getHeight() * value);
	    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	    Sequence sequence = new Sequence(finger1, 1)
	        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
	        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(new Pause(finger1, Duration.ofMillis(200)))
	        .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
	        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    android.perform(Collections.singletonList(sequence));
	}
	
	
	public void scrollUpWithParameter(double value) {
		Dimension size = android.manage().window().getSize();
	    int startX = size.getWidth() / 2;
	    int startY = size.getHeight() / 2;
	    int endX = startX;
	    int endY = (int) (size.getHeight() * value);
	    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	    Sequence sequence = new Sequence(finger1, 1)
	        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
	        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(new Pause(finger1, Duration.ofMillis(200)))
	        .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
	        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    android.perform(Collections.singletonList(sequence));
	}
	
	public void swipeLeftNoParameter() {
		 Dimension size = android.manage().window().getSize();
		    int startX = (int) (size.getWidth() * 0.8); // Starting from 80% of the screen width
		    int endX = (int) (size.getWidth() * 0.2); // Ending at 20% of the screen width
		    int startY = size.getHeight() / 2; // Center of the screen

		    TouchAction<?> action = new TouchAction<>(android);
		    action.press(PointOption.point(startX, startY))
		          .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) // Adjust the duration if needed
		          .moveTo(PointOption.point(endX, startY))
		          .release()
		          .perform();
	}
	
	public void swipeRightNoParameter() {
		Dimension size = android.manage().window().getSize();
	    int startX = (int) (size.getWidth() * 0.2); // Starting from 20% of the screen width
	    int endX = (int) (size.getWidth() * 0.8); // Ending at 80% of the screen width
	    int startY = size.getHeight() / 2; // Center of the screen

	    TouchAction<?> action = new TouchAction<>(android);
	    action.press(PointOption.point(startX, startY))
	          .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) // Adjust the duration if needed
	          .moveTo(PointOption.point(endX, startY))
	          .release()
	          .perform();
	}

	public void LongPress(WebElement peopleNames) {
		((JavascriptExecutor) android).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) peopleNames).getId(), "duration",2000));
	}
	
	public void SwipeGesture(WebElement firstElement) {
		Dimension size = android.manage().window().getSize();
	    int startX = size.getWidth();
	    int startY = size.getHeight();
	    
		((JavascriptExecutor) android).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) firstElement).getId(),
			    "left", startX / 4, "top", startY / 2, "width", startX / 2, "height", 10,
			    "direction", "left",
			    "percent", 0.75
			));
	}
	
}
