package org.visionplus_android.visitor.TC_Login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.visionplus_android.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.LainnyaMenuPage;
import org.visionplus_android.pageObjects.android.LoginPageVisionPlus;
import org.visionplus_android.pageObjects.android.PengaturanPage;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class TC_SuccessLoginSignOut extends BaseTest{
	
	
	@Test(dataProvider="getData")
	public void TC_SuccessLoginSignOut (HashMap<String, String> input) throws InterruptedException{
		
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		Thread.sleep(3000);	
		homepage.lewatiButton();
		test.info("User berhasil Klik skip button");
		Thread.sleep(3000);
		homepage.lainnyaButton();
		test.info("User berhasil Klik menu Lainnya");
		Thread.sleep(3000);
		login.clickMasukButton();
		test.info("User berhasil Klik Button Masuk");
		Thread.sleep(3000);
		login.LoginVisionPlus(input.get("loginWith"), input.get("username"), input.get("password"));
		login.clickButtonContinue();
		test.pass("User memilih login dengan Phone");
		homepage.removePopupSub();
		homepage.lainnyaButton();
		test.info("User berhasil Klik menu Lainnya");
		LainnyaMenuPage lainnya = new LainnyaMenuPage(android);
		lainnya.pengaturanLainnya();
		PengaturanPage pengaturan = new PengaturanPage(android);
		pengaturan.SignOut();
		test.info("User berhasil Sign out dari Aplikasi");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/org/visionplus_android/TestData/LoginTestdata/login.json");
		return new Object[][] {{data.get(0)}};
		
	}
	
	
}
