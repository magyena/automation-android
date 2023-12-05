package id.visionplus.Action;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.PageObjects.HomePageVisionPlus;
import id.visionplus.PageObjects.LainnyaMenuPage;
import id.visionplus.PageObjects.VODPage;
import id.visionplus.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Swipe extends AndroidGesture
{

	AndroidDriver android;
	WebDriverWait wait;
	HomePageVisionPlus homePage;
	LainnyaMenuPage lainnyaPage;
	VODPage vodPage;
	
	public Swipe(AndroidDriver android) {
		super(android);
		this.android = android;
	    homePage = new HomePageVisionPlus(android);
	    lainnyaPage = new LainnyaMenuPage(android);
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
