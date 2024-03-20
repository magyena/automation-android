package id.visionplus.v2.TestCase.PremiumSport;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_Homepage;

public class TC_Premium_Sport_User_Watch_VOD extends BaseTest{
	
	Click click = new Click();
	Assertion assertion = new Assertion();	
	@Test
	public void TC_Free_User_Watch_Free_VOD() throws IOException, InterruptedException, TimeoutException {
		TC_Homepage tc_homePage = new TC_Homepage();
		tc_homePage.TC_Access_VOD_Detail();
		
	    click.clickEps1VOD();
	    test.pass("Successfully Clicked Episode 1 Button");
	    
	    Thread.sleep(2000);

	    click.clickWatchVOD();
	    test.pass("Successfully Clicked Watch Button");
	    
	    Thread.sleep(10000);
	    
		click.pressBack();
	    test.pass("Successfully Press Back to VOD Details Page");
	}
}
