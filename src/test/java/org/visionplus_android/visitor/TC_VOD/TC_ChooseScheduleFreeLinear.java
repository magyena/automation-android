package org.visionplus_android.visitor.TC_VOD;

import java.time.Duration;

import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.VODPage;

public class TC_ChooseScheduleFreeLinear extends BaseTest {
	
	@Test
	public void TC_ChooseScheduleFreeLinear() throws InterruptedException {
		
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		homepage.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		homepage.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		homepage.clickBtnTVku();
		test.pass("User berhasil Klik Button TV ku");
		VODPage vod = new VODPage(android);
		vod.clickBtnFreeLinearAntv();
		test.pass("User berhasil Klik Button ANTV");
		Thread.sleep(10000);
		vod.clickBtnChromeCast();
		test.pass("User berhasil Klik Button Chromecast");
		vod.clickBtnDataSaver();
		test.pass("User berhasil Klik Button Data Saver");
		vod.clickBtnSchedule();
		test.pass("User berhasil Klik Button Schedule");
		vod.clickBtnScheduleCatchup();
		test.pass("User berhasil Choose Schedule");
		vod.assertErrorChooseSchedule();
	}

}
