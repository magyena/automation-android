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
import org.visionplus_android.pageObjects.android.TvKUPageVisionPlus;
import org.visionplus_android.pageObjects.android.VODPage;

public class TS_Visitor extends BaseTest
{
	
	
	@Test(priority = 1,testName = "User Add Daftarku With Visitor")
	public void user_Add_Daftarku_With_Visitor() throws InterruptedException 
	{
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		VODPage vodPage = new VODPage(android);
		MenuFooterPage menuFooterPage = new MenuFooterPage(android);
		AssertPage assertPage = new AssertPage(android);
		
		
		homepage.lewatiButton();
		test.pass("User berhasil Klik skip button");
		Thread.sleep(3000);
		
		homepage.clickBtnShowcaseTvConnect();
		test.pass("sukses lewati button showcase");
		
		homepage.clickBtnShowcaseOk();
		test.pass("sukses lewati button showcase");
		
		homepage.lainnyaButton();
		
		menuFooterPage.clickMenuBeranda();
		
		homepage.clickBanner();
		
		vodPage.clickWatchList();
		
		assertPage.assert_LoginPageShouldBeDisplayed();
		
	}
	
	@Test(priority = 2,testName = "User Download VOD Series")
	public void user_Download_VOD_Series() throws InterruptedException 
	{
		HomePageVisionPlus homepage = new HomePageVisionPlus(android);
		LoginPageVisionPlus login = new LoginPageVisionPlus(android);
		VODPage vodPage = new VODPage(android);
		MenuFooterPage menuFooterPage = new MenuFooterPage(android);
		AssertPage assertPage = new AssertPage(android);
		
		android.navigate().back();
		
		menuFooterPage.clickMenuBeranda();
		
		homepage.clickBanner();
		
		vodPage.clickDownload();
		
		assertPage.assert_LoginPageShouldBeDisplayed();
		
	}
	

	
	
	
	
	
}
