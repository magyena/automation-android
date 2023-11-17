package org.visionplus_android.visitor.TC_Login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.assertion.AssertPage;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.LoginPageVisionPlus;
import org.visionplus_android.pageObjects.android.MenuFooterPage;
import org.visionplus_android.pageObjects.android.MenuHeaderPage;
import org.visionplus_android.pageObjects.android.TvKUPageVisionPlus;
import org.visionplus_android.pageObjects.android.VODPage;
import org.visionplus_android.pageObjects.android.VplusOriPage;

public class TS_Visitor extends BaseTest
{
	
	
	@Test(priority = 1,testName = "User Add Daftarku With Visitor")
	public void user_Add_Daftarku_With_Visitor() throws InterruptedException 
	{
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		VODPage vodPage = new VODPage(android);
		MenuFooterPage menuFooterPage = new MenuFooterPage(android);
		MenuHeaderPage menuHeaderPage = new MenuHeaderPage(android);
		VplusOriPage menuVplusOriPage =  new VplusOriPage(android);
		AssertPage assertPage = new AssertPage(android);
		
		
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		
		homepage.clickBtnShowcaseTvConnect();
		test.pass("sukses lewati button showcase");
		
		homepage.clickBtnShowcaseOk();
		test.pass("sukses lewati button showcase");
		
		//homepage.lainnyaButton();
		
		menuHeaderPage.clickMenuVplusOriginal();
		
		menuVplusOriPage.clickMenuVplusOriginalSelengkapnya();

		menuVplusOriPage.clickFirstVOD();
		
		menuVplusOriPage.scrollDownWithParameter(0.1);
		
		vodPage.clickWatchList();
		
		assertPage.assert_LoginPageShouldBeDisplayed();
		
	}
	
	@Test(priority = 2,testName = "User visitor Download VOD Series")
	public void user_Download_VOD_Series() throws InterruptedException 
	{
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		VODPage vodPage = new VODPage(android);
		MenuFooterPage menuFooterPage = new MenuFooterPage(android);
		AssertPage assertPage = new AssertPage(android);
		
		android.navigate().back();
		
		
		homepage.scrollDownWithParameter(0.1);
				
		vodPage.clickDownload();
		
		assertPage.assert_LoginPageShouldBeDisplayed();
		
	}
	
	
	@Test(priority = 3,testName = "User Visitor Watch Sport Channel")
	public void User_Visitor_Watch_Sport_Channel() throws InterruptedException 
	{
		MenuFooterPage menuFooterPage = new MenuFooterPage(android);
		AssertPage assertPage = new AssertPage(android);
		TvKUPageVisionPlus tvKUPageVisionPlus = new TvKUPageVisionPlus(android);
		
		for (int i=0 ; i<3 ;i++)
		{
			android.navigate().back();
		}
	
		menuFooterPage.clickliveTv();
		Thread.sleep(3000);
		
		tvKUPageVisionPlus.scrollDownWithParameter(0.1);
		
		tvKUPageVisionPlus.clickSportStar();

		
		tvKUPageVisionPlus.assertPopupLogin();
		tvKUPageVisionPlus.assertLogin();
	}
	
	@Test(priority = 4,dataProvider = "wrongNumber",testName = "User Visitor Login with Wrong Number")
	public void UserVisitorLoginWithWrongNumber(HashMap<String, String> input) throws InterruptedException 
	{
		
		HomePageVisionPlus homePageVisionPlus = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		TvKUPageVisionPlus tkuPageVisionPlus = new TvKUPageVisionPlus(android);
		
		tkuPageVisionPlus.clickMasuk();
		
		login.inputPhoneNumber(input.get("phone"));
		test.info("User input nomor yang salah");
		login.clickButtonContinue();
		login.assertWrongPhoneNumber();
		test.pass("hasil Assert sesuai");
	}
	
	
	@Test(priority = 5,dataProvider = "wrongPassword",testName = "User Visitor Login with Wrong Password")
	public void UserVisitorLoginWithWrongPassword(HashMap<String, String> input) throws InterruptedException 
	{
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		
		login.inputPhoneNumber(input.get("phone"));
		login.clickButtonContinue();
		login.inputPhonePassword(input.get("password"));
		login.clickButtonContinue();
		login.assertWrongPhonePassword();
		test.pass("hasil Assert sesuai");
	}
	
	@DataProvider
	public Object[][] wrongNumber() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/org/visionplus_android/TestData/LoginTestdata/TC_loginWrongPhoneNumber.json");
		return new Object[][] {{data.get(0)}};
		
	}
	
	@DataProvider
	public Object[][] wrongPassword() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/org/visionplus_android/TestData/LoginTestdata/TC_loginWrongPhonePassword.json");
		return new Object[][] {{data.get(0)}};
		
	}

	
	
	
	
	
	
}
