package id.visionplus.v2.TestCase.General;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Swipe;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.Visitor.Login.TC_Login_As_Free_User_Email;

public class TC_Homepage extends BaseTest{
	Click click = new Click();
	Assertion assertion = new Assertion();
	@Test
	public void TC_Access_VOD_Detail() throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		open_app.TC_Open_App_as_Free_User();
		
	    click.clickVODBanner();
	    test.pass("Successfully Clicked VOD Banner");
	    
	    assertion.assertVODDetails();
	    test.pass("Successfully Assert VOD Details");
	}
	
	@Test
	public void TC_Access_VOD_VPlus_Detail() throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		open_app.TC_Open_App_as_Free_User();
		
		click.clickVisionPlusOriginalSeriesContent();
	    test.pass("Successfully Clicked Vision Plus Originals Content");
	    
	    assertion.assertVODDetails();
	    test.pass("Successfully Assert VOD Details");
	}
	
	@Test(dependsOnMethods="TC_Access_VOD_Detail")
	public void TC_Swipe_VisionPlusOriginals() throws IOException, InterruptedException, TimeoutException {
	    click.clickBack();
	    test.pass("Successfully Clicked Back to Homepage");
	    
		Swipe swipe = new Swipe(android);
		
		swipe.swipeLeft();
	    test.pass("Successfully Swiped Vision Plus Originals");
	}
	
	@Test(dependsOnMethods="TC_Swipe_VisionPlusOriginals")
	public void TC_Access_VisionPlusOriginals() throws IOException, InterruptedException, TimeoutException {
		click.clickVisionPlusOriginalsSeries();
	    test.pass("Successfully Clicked Vision Plus Originals");
	    
	    assertion.assertVODDetails();
	    test.pass("Successfully Assert VOD Details");
	    
	    click.clickBack();
	    test.pass("Successfully Clicked Back to Homepage");
	}
}