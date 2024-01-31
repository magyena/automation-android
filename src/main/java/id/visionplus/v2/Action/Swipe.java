package id.visionplus.v2.Action;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Swipe extends AndroidGesture
{

	AndroidDriver android;
	WebDriverWait wait;

	public Swipe(AndroidDriver android) {
		super(android);
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}
	
	public void swipeBannerLeft() {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.swipeLeftNoParameter();
	}
	
	public void swipeBannerRight() {
		AndroidGesture gesture = new AndroidGesture(android);
		gesture.swipeRightNoParameter();
	}
}
