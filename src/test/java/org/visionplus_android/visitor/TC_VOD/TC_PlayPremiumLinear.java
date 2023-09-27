package org.visionplus_android.visitor.TC_VOD;

import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.VODPage;

public class TC_PlayPremiumLinear extends BaseTest{
	
	@Test
	public void TC_PlayPremiumLinear() throws InterruptedException {
		
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
		vod.clickBtnPremiumLinearTransTV();
		test.pass("User berhasil Klik Premium Linear");
		vod.assertErrorSubcriptionPremiumLinear();
		test.pass("Assert sesuai!");
		Thread.sleep(3000);
	}

}
