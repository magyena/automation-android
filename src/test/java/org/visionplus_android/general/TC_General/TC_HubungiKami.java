package org.visionplus_android.general.TC_General;

import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.LainnyaMenuPage;
import org.visionplus_android.pageObjects.android.LoginPageVisionPlus;

public class TC_HubungiKami extends BaseTest{

	@Test
	public void TC_HubungiKami() throws InterruptedException {
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		homepage.lainnyaButton();
		test.pass("User berhasil Klik menu Lainnya");
		LainnyaMenuPage lainnya = new LainnyaMenuPage(android);
		lainnya.clickBtnLainnya();
		lainnya.clickBtnHubungiKami();
		Thread.sleep(3000);
		lainnya.assertTextHubungiKami();
		lainnya.clickPertanyaanEnglish();
		lainnya.assertTextContactUs();
		Thread.sleep(3000);
		
	}
	
}
