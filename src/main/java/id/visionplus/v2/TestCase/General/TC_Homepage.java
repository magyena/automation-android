package id.visionplus.v2.TestCase.General;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.Action.Swipe;
import id.visionplus.v2.MainFunction.BaseTest;

public class TC_Homepage extends BaseTest{
	Click click = new Click();
	Assertion assertion = new Assertion();
	
    // Get the test case type from TestNG parameters
    String testCaseType = System.getProperty("testCaseType");
    
	@Test
	public void TC_Access_VOD_Detail() throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
        if ("PREMIUM_SPORT".equals(testCaseType)) {
            open_app.Choose_Login_As("PREMIUM_SPORT");
        } else if ("FREE".equals(testCaseType)) {
            open_app.Choose_Login_As("FREE");
        }
		
	    click.clickVisionPlusOriginalsSeries();
	    test.pass("Successfully Clicked VOD Vision Plus Originals");
	    
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
	}
	
	@Test(dependsOnMethods="TC_Access_VisionPlusOriginals")
	public void TC_Swipe_Live_TV() throws IOException, InterruptedException, TimeoutException {
	    click.clickBack();
	    test.pass("Successfully Clicked Back to Homepage");
	    
	    Thread.sleep(1000);

		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//*[contains(@text,'Your Favorite TV Channel')]");
	    scroll.scrollUntilElementFound(locator);
	    
	    click.clickViewAll();
	    
		Swipe swipe = new Swipe(android);
		
		swipe.swipeLeft();
	    test.pass("Successfully Swiped Live Tv");
	    
	    click.pressBack();
	}
	
	@Test(dependsOnMethods="TC_Swipe_Live_TV")
	public void TC_Swipe_Top_10() throws IOException, InterruptedException, TimeoutException {   
		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//*[contains(@text,'Top 10 This Week')]");
	    scroll.scrollUntilElementFound(locator);
	    	    	    
		Swipe swipe = new Swipe(android);
		
		swipe.swipeLeft();
	    test.pass("Successfully Swiped Top 10"); 
	}
	
	@Test(dependsOnMethods="TC_Swipe_Top_10")
	public void TC_Click_Top_10() throws IOException, InterruptedException, TimeoutException {
	    click.clickVisionPlusOriginalsSeries();
		test.pass("Successfully Clicked VOD in Top 10");
		
	    assertion.assertVODDetails();
	    test.pass("Successfully Assert VOD Details");
	}
}
