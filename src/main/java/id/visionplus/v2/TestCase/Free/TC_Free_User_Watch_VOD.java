package id.visionplus.v2.TestCase.Free;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_Homepage;

public class TC_Free_User_Watch_VOD extends BaseTest{
	
	Click click = new Click();
	Assertion assertion = new Assertion();	
	@Test
	public void TC_Free_User_Watch_Free_VOD() throws IOException, InterruptedException, TimeoutException {
		TC_Homepage tc_homePage = new TC_Homepage();
		tc_homePage.TC_Access_VOD_VPlus_Detail();
		
	    click.clickEps1VOD();
	    test.pass("Successfully Clicked Episode 1 Button");
	    
	    Thread.sleep(2000);

	    click.clickWatchVOD();
	    test.pass("Successfully Clicked Watch Button");
	    
	    Thread.sleep(10000);
	    
		click.pressBack();
	    test.pass("Successfully Pressed Back Button");
	}
	
	@Test(dependsOnMethods="TC_Free_User_Watch_Free_VOD")
	public void TC_Free_User_Cannot_Watch_Premium_VOD_Series() throws IOException, InterruptedException, TimeoutException {
		click.clickBack();
	    test.pass("Successfully Clicked Back to VOD Details Page");
	    
	    Scroll scroll = new Scroll(android);
		By locator = By.xpath("//android.view.View[starts-with(@content-desc,'E5')]");
		scroll.scrollUntilElementFound(locator);
	    test.pass("Successfully Scroll Down Until VOD EP 5 Appear");
	    
	    click.clickEps5VOD();
	    test.pass("Successfully Clicked Episode 5 Button");
	    
	    Thread.sleep(2000);

	    assertion.assertVODIsNotPlayable();
	    test.pass("Successfully Assert VOD Episode 5 is Not Playable and Need to Subscribe");
	}
}
