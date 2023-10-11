package org.visionplus_android.general.TC_General;

import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.LainnyaMenuPage;
import org.visionplus_android.pageObjects.android.LoginPageVisionPlus;

public class TC_Pertanyaan extends BaseTest{

	@Test
	public void TC_Pertanyaan() throws InterruptedException {
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		homepage.lainnyaButton();
		test.pass("User berhasil Klik menu Lainnya");
		LainnyaMenuPage lainnya = new LainnyaMenuPage(android);
		lainnya.clickBtnLainnya();
		lainnya.clickBtnPertanyaan();
		Thread.sleep(5000);
		lainnya.assertTextRegistrasi();
		lainnya.clickPertanyaanEnglish();
		lainnya.assertTextRegistration();
		Thread.sleep(3000);
	}
}
