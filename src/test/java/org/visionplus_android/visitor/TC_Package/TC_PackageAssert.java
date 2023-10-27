package org.visionplus_android.visitor.TC_Package;

import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.LainnyaMenuPage;

public class TC_PackageAssert extends BaseTest{
	
	@Test
	public void TC_PackageAssert() throws InterruptedException {
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		homepage.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		Thread.sleep(3000);
		homepage.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		Thread.sleep(3000);
		homepage.lainnyaButton();
		test.pass("User berhasil Klik Pengaturan");
		Thread.sleep(3000);
		LainnyaMenuPage lainnya = new LainnyaMenuPage(android);
		Thread.sleep(3000);
		lainnya.clickPaketButton();
		test.pass("User berhasil Klik Button Paket");
		lainnya.assertTextPremiumSport();
		lainnya.clickBtnTextPremium();
		test.pass("User berhasil Klik Premium");
		lainnya.assertTextPremium();
		test.pass("Assert sesuai");
	}
	
}
