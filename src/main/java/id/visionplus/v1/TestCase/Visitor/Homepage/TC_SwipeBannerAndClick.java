package id.visionplus.v1.TestCase.Visitor.Homepage;

import org.testng.annotations.Test;

import id.visionplus.v1.Action.Click;
import id.visionplus.v1.Action.Swipe;
import id.visionplus.v1.MainFunction.*;

public class TC_SwipeBannerAndClick extends BaseTest {
	
	@Test
	public void TC_SwipeBannerAndClick() throws InterruptedException {
		Click click = new Click();
		Swipe swipe = new Swipe(android);
		
		Thread.sleep(3000);
		click.lewatiButton();
		test.pass("User berhasil Klik skip button");
		
		Thread.sleep(3000);
		click.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		
		click.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		
		swipe.swipeBannerRight();
		swipe.swipeBannerRight();
		test.pass("User berhasil Swipe Banner");
		
		Thread.sleep(3000);
		click.clickBanner();
		test.pass("User berhasil Klik Banner");
		Thread.sleep(3000);
	}

}
