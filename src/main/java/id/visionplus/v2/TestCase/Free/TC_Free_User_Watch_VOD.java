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
	
	@Test(dependsOnMethods="TC_Free_User_Watch_Free_VOD")
	public void TC_Free_User_Cannot_Watch_Premium_VOD_Series() throws IOException, InterruptedException, TimeoutException {
		click.pressBack();
	    test.pass("Successfully Press Back to VOD Details Page");
	    
	    Scroll scroll = new Scroll(android);
		By locator = By.xpath("//android.view.View[starts-with(@content-desc,'E7')]");
		scroll.scrollUntilElementFound(locator);
	    test.pass("Successfully Scroll Down Until VOD EP 7 Appear");
	    
	    click.clickEps7VOD();
	    test.pass("Successfully Clicked Episode 7 Button");
	    
	    Thread.sleep(2000);

	    assertion.assertVODIsNotPlayable();
	    test.pass("Successfully Assert VOD Episode 5 is Not Playable and Need to Subscribe");
	}
	
	@Test(dependsOnMethods="TC_Free_User_Cannot_Watch_Premium_VOD_Series")
	public void TC_Free_User_Access_Subscribe_From_VOD() throws IOException, InterruptedException, TimeoutException {
		click.clickSubscribe();
	    test.pass("Successfully Clicked Subscribe Button");
	    
	    assertion.assertPopUpPackages();
	    test.pass("Successfully Assert Pop Up Packages");
	    
	    click.pressBack();
	    test.pass("Successfully Press Back Button");
	}
}
