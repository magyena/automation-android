package org.visionplus_android.visitor.TC_Homepage;

import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.LoginPageVisionPlus;

public class TC_SwipeBannerAndClick extends BaseTest {
	
	@Test
	public void TC_SwipeBannerAndClick() throws InterruptedException {
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		homepage.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		homepage.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		homepage.swipeBanner();
		test.pass("User berhasil Swipe Banner");
		homepage.clickBanner();
		test.pass("User berhasil Klik Banner");
		Thread.sleep(3000);
	}

}
