package id.visionplus.v1.Action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import id.visionplus.v1.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

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
	
	public void scrollDown(double value) {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollDownWithParameter(value);
	}
	
	public void scrollUpNoParameter(double value) {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.scrollUpWithParameter(1);
	}
}
