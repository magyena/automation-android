package id.visionplus.v2.TestCase.General;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_Homepage;

public class TC_VOD_Details extends BaseTest{
	
	Click click = new Click();
	Assertion assertion = new Assertion();	
	@Test
	public void TC_User_Like_VOD() throws IOException, InterruptedException, TimeoutException {
		TC_Homepage tc_homePage = new TC_Homepage();
		tc_homePage.TC_Access_VOD_Detail();
		
	    click.clickLikeVOD();
	    test.pass("Successfully Clicked Like Button");
	    
	    Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods="TC_User_Like_VOD")
	public void TC_User_Disike_VOD() throws IOException, InterruptedException, TimeoutException {
		click.clickDislikeVOD();
	    test.pass("Successfully Clicked Dislike Button");
	}
	
	@Test(dependsOnMethods="TC_User_Like_VOD")
	public void TC_User_Share_VOD() throws IOException, InterruptedException, TimeoutException {
		click.clickShareVOD();
	    test.pass("Successfully Clicked Share Button");
	    
	    assertion.assertShareSection();
	    test.pass("Successfully Assert Share Section");
	    
	    click.clickCopyLink();
	    test.pass("Successfully Clicked Share Copy Link Button");
	    
	    click.pressBack();
	    test.pass("Successfully Press Back Button");
	}
}
