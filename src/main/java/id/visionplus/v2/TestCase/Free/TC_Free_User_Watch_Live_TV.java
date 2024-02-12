package id.visionplus.v2.TestCase.Free;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_Menu;

public class TC_Free_User_Watch_Live_TV extends BaseTest{
	
	Click click = new Click();
	Assertion assertion = new Assertion();
	@Test
	public void TC_Free_User_Watch_Free_Linear() throws IOException, InterruptedException, TimeoutException {
		TC_Menu tc_Menu = new TC_Menu();
		tc_Menu.TC_Access_Live_Tv();
	    test.pass("Successfully Access to RCTI in Live TV Page");
	    
	    click.clickFreeLinear();
	    test.pass("Successfully Clicked Free Linear Channel");
	    
	    Thread.sleep(35000);
	    
	    assertion.assertLiveTVPlayed();
	    test.pass("Successfully Assert Live TV is Played");
	}
	
	@Test(dependsOnMethods="TC_Free_User_Watch_Free_Linear")
	public void TC_Free_User_Cannot_Watch_Premium_Linear() throws IOException, InterruptedException, TimeoutException {
		click.clickPremiumLinear();
	    test.pass("Successfully Clicked Premium Linear Channel");

	    Thread.sleep(10000);

	    assertion.assertLiveTVNotPlayed();
	    test.pass("Successfully Assert Live TV is NOT Played");

	}
	
	@Test(dependsOnMethods="TC_Free_User_Cannot_Watch_Premium_Linear")
	public void TC_Free_User_Cannot_Watch_Premium_Sport_Linear() throws IOException, InterruptedException, TimeoutException {
		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//*[contains(@text,'115')]");
		scroll.scrollUntilElementFound(locator);
		
		click.clickPremiumSportLinear();
	    test.pass("Successfully Clicked Premium Sport Linear Channel");

	    Thread.sleep(10000);
	    
	    assertion.assertLiveTVNotPlayed();
	    test.pass("Successfully Assert Live TV is NOT Played");

	}
}
