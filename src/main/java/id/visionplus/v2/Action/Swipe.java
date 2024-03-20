package id.visionplus.v2.Action;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Point;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.time.Duration;
import java.util.Arrays;
import javax.swing.text.View;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.TouchAction;
import id.visionplus.v2.MainFunction.BaseTest;
import java.util.Arrays;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.WaitOptions;

import java.time.Duration;

public class Swipe extends BaseTest {

	private AndroidDriver android;

	public Swipe(AndroidDriver android) {
		this.android = android;
	}
	
    public void swipeLeft() {
        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(932, 1650);
        Point end = new Point (1083, 1650);
        Sequence swipe = new Sequence(FINGER, 1)
                    .addAction(
                            FINGER.createPointerMove(
                                    Duration.ofMillis(0),
                                    PointerInput.Origin.viewport(),
                                    start.getX(),
                                    start.getY()))
                    .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(
                            FINGER.createPointerMove(
                                    Duration.ofMillis(1000),
                                    PointerInput.Origin.viewport(),
                                    end.getX(),
                                    end.getY()))
                    .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            android.perform(Arrays.asList(swipe));
    }

	public void swipeFirstRightBannerHomepage() {
		final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Point start = new Point(1033, 547);
		Point end = new Point(32, 555);
		Sequence swipee = new Sequence(FINGER, 1)
				.addAction(FINGER.createPointerMove(Duration.ofMillis(3000), PointerInput.Origin.viewport(), start.getX(),
						start.getY()))
				.addAction(FINGER.createPointerDown(PointerInput.MouseButton.RIGHT.asArg()))
				.addAction(FINGER.createPointerMove(Duration.ofMillis(3000), PointerInput.Origin.viewport(), end.getX(),
						end.getY()))
				.addAction(FINGER.createPointerUp(PointerInput.MouseButton.RIGHT.asArg()));
		android.perform(Arrays.asList(swipee));
	}
	public void swipeSecondRightBannerHomepage() {
		final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Point start = new Point(1061, 491);
		Point end = new Point(24, 491);
		Sequence swipee = new Sequence(FINGER, 1)
				.addAction(FINGER.createPointerMove(Duration.ofMillis(3000), PointerInput.Origin.viewport(), start.getX(),
						start.getY()))
				.addAction(FINGER.createPointerDown(PointerInput.MouseButton.RIGHT.asArg()))
				.addAction(FINGER.createPointerMove(Duration.ofMillis(3000), PointerInput.Origin.viewport(), end.getX(),
						end.getY()))
				.addAction(FINGER.createPointerUp(PointerInput.MouseButton.RIGHT.asArg()));
		android.perform(Arrays.asList(swipee));
	}
	public void swipeLeftProgramGuide(java.awt.Point start, java.awt.Point end) {
	    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence swipee = new Sequence(FINGER, 1)
	            .addAction(FINGER.createPointerMove(Duration.ofMillis(3000), PointerInput.Origin.viewport(), (int) start.getX(),
	                    (int) start.getY()))
	            .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	            .addAction(FINGER.createPointerMove(Duration.ofMillis(3000), PointerInput.Origin.viewport(), (int) end.getX(),
	                    (int) end.getY()))
	            .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	    android.perform(Arrays.asList(swipee));
	}
}

