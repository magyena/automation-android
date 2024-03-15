package id.visionplus.v2.Action;

import id.visionplus.v2.MainFunction.BaseTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Tap extends BaseTest{
	
	
	 public void tap(int x, int y) {
	        TouchAction touchAction = new TouchAction(android);
	        touchAction.tap(PointOption.point(x, y)).perform();
	    }

}
