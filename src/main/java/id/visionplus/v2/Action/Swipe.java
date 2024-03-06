package id.visionplus.v2.Action;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import static io.appium.java_client.touch.offset.ElementOption.element;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import id.visionplus.v2.MainFunction.BaseTest;

public class Swipe extends BaseTest{
	
	 private AndroidDriver android;
	 
    public Swipe(AndroidDriver android) {
        this.android = android;
    }

    public void swipeLeft() {
        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(932, 1637);
        Point end = new Point (278, 1648);
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
}
