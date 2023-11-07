package org.visionplus_android.premium;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.DestroySession;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.LoginPageVisionPlus;
import org.visionplus_android.pageObjects.android.TvKUPageVisionPlus;

public class UserPremium extends BaseTest
{
	
	@Test(dataProvider="getData",priority = 1,testName = "Login ke account premium")
	public void loginToPremiumAccount(HashMap<String, String> input) throws InterruptedException 
	{
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		homepage.lainnyaButton();
		test.pass("User berhasil Klik menu Lainnya");
		login.clickMasukButton();
		login.inputPhoneNumber(input.get("phone"));
		test.info("User input nomor yang salah");
		login.clickButtonContinue();
		test.pass("hasil Assert sesuai");
		login.inputPhonePassword(input.get("password"));
		login.clickButtonContinue();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException 
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/org/visionplus_android/TestData/LoginTestdata/loginPremium.json");
		return new Object[][] {{data.get(0)}};
		
	}
	
	@Test(priority = 2)	
	public void playSportChannel() throws InterruptedException
	{
		TvKUPageVisionPlus tvKUPageVisionPlus =  new TvKUPageVisionPlus(android);
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		
		homepage.clickBtnTVku();
		test.pass("Sukses lewati button TVku");
		
		Thread.sleep(3000);
		tvKUPageVisionPlus.scrollDown(0.1);
		
		tvKUPageVisionPlus.clickSportStar();
	}
	
	/*
	 * @Test(priority = 3) public void playSportContent() throws
	 * InterruptedException { TvKUPageVisionPlus tvKUPageVisionPlus = new
	 * TvKUPageVisionPlus(android); HomePageVisionPlus homepage = new
	 * HomePageVisionPlus(android);
	 * 
	 * homepage.clickBtnTVku(); test.pass("Sukses lewati button TVku");
	 * 
	 * Thread.sleep(3000); tvKUPageVisionPlus.scrollDown(0.1);
	 * 
	 * tvKUPageVisionPlus.clickSportStar(); }
	 */
	
	
	
}
