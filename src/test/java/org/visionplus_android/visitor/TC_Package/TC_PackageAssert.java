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
		homepage.clickBtnShowcaseTvConnect();
		test.pass("User berhasil Klik Button Showcase TV Connect");
		homepage.clickBtnShowcaseOk();
		test.pass("User berhasil Klik Button Showcase OK");
		homepage.lainnyaButton();
		test.pass("User berhasil Klik Pengaturan");
		LainnyaMenuPage lainnya = new LainnyaMenuPage(android);
		lainnya.clickPaketButton();
		test.pass("User berhasil Klik Button Paket");
		lainnya.assertTextPremiumSport();
		test.pass("Assert sesuai");
		lainnya.clickBtnTextPremium();
		test.pass("User berhasil Klik Premium");
		lainnya.assertTextPremium();
		test.pass("Assert sesuai");
	}
	
}
