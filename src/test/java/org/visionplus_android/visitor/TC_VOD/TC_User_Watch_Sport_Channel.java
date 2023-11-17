package org.visionplus_android.visitor.TC_VOD;

import org.testng.annotations.Test;
import org.visionplus_android.BaseTest;
import org.visionplus_android.pageObjects.android.HomePageVisionPlus;
import org.visionplus_android.pageObjects.android.TvKUPageVisionPlus;
import org.visionplus_android.pageObjects.android.VODPage;

public class TC_User_Watch_Sport_Channel extends BaseTest
{
	@Test
	public void TC_User_Watch_Sport_Channel() throws InterruptedException
	{
		try
		{
			HomePageVisionPlus homePageVisionPlus = new HomePageVisionPlus(android);

			TvKUPageVisionPlus tvKUPageVisionPlus =  new TvKUPageVisionPlus(android);
			
			homePageVisionPlus.lewatiButton();
			test.pass("Sukses lewati button");

			homePageVisionPlus.clickBtnShowcaseTvConnect();
			test.pass("sukses lewati button showcase");
			
			homePageVisionPlus.clickBtnShowcaseOk();
			test.pass("sukses lewati button showcase");
			
			homePageVisionPlus.lainnyaButton();
			//test.pass("Sukses lewati button");
			
			homePageVisionPlus.clickBtnTVku();
			test.pass("Sukses lewati button TVku");
			
			tvKUPageVisionPlus.scrollDown(0.1);
			
			tvKUPageVisionPlus.clickSportStar();
			test.pass("sukses klik sporstar");
			
			
			tvKUPageVisionPlus.assertPopupLogin();
			tvKUPageVisionPlus.assertLogin();
			
		} 
		catch (Exception e) 
		{
			
		}
	
		
	}

}
