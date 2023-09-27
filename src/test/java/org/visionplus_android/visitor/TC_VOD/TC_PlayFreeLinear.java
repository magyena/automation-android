package org.visionplus_android.visitor.TC_VOD;

import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.VODPage;

import io.appium.java_client.android.AndroidDriver;

public class TC_PlayFreeLinear extends BaseTest{

	@Test
	public void TC_PlayFreeLinear() throws InterruptedException {
		
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		homepage.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		homepage.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		homepage.clickBtnTVku();
		test.pass("User berhasil Klik Button TV ku");
		VODPage vod = new VODPage(android);
		vod.clickBtnFreeLinearAntv();
		vod.assertTitleChannelNationalTV();
		Thread.sleep(3000);
	}
	
}
