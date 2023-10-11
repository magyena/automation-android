package org.visionplus_android.visitor.TC_VOD;

import java.time.Duration;

import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.VODPage;

public class TC_PlayFreeVOD extends BaseTest{
	
	@Test
	public void TC_PlayFreeVOD() throws InterruptedException {
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		homepage.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		homepage.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		homepage.scrollDown(0.37);
		VODPage vod = new VODPage(android);
		vod.clickPremiumVOD();
		Thread.sleep(2000);
		homepage.scrollDown(0.3);
		vod.clickEps1VOD();
		Thread.sleep(5000);
		vod.clickBtnChromeCast();
		test.pass("User berhasil Klik Button Chromecast");
		vod.clickBtnDataSaver();
		android.manage().timeouts().implicitlyWait(Duration.ofMinutes(13));
		vod.assertErrorSubcriptionPremiumLinear();
	}

}
