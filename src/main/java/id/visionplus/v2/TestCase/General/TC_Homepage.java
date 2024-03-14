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
	
// 	  Get the test case type from TestNG parameters
//    String testCaseType = System.getProperty("testCaseType");
    
    String testCaseType = "FREE";

	@Test(priority=1)
	public void TC_Access_VOD_Detail() throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
        if ("PREMIUM_SPORT".equals(testCaseType)) {
            open_app.Choose_Login_As("PREMIUM_SPORT");
        } else if ("FREE".equals(testCaseType)) {
            open_app.Choose_Login_As("FREE");
        }
		
	    click.clickVisionPlusOriginalsSeries();
	    test.pass("Successfully Clicked VOD Vision Plus Originals");

	    assertion.assertContentDetails();
	    test.pass("Successfully Assert Contenty Details");
	}
	
	@Test(priority=2,dependsOnMethods="TC_Access_VOD_Detail")
	public void TC_Click_Banner() throws IOException, InterruptedException, TimeoutException {
	    click.pressBack();

		click.clickVODBanner();	    
		test.pass("Successfully Clicked Banner");
	    
	    assertion.assertContentDetails();
	    test.pass("Successfully Assert Banner Details");
	}
	
	@Test(priority=3,dependsOnMethods="TC_Click_Banner")
	public void TC_Play_Banner() throws IOException, InterruptedException, TimeoutException {
		try {
		    click.clickWatchVOD();
		    test.pass("Successfully Clicked Watch VOD");
		} catch (Exception e) {
		    System.out.println("Failed to click Watch VOD: " + e.getMessage());
		    try {
		        click.clickSubscribe();
		        test.pass("Successfully Clicked Subscribe");
		    } catch (Exception ex) {
		        System.out.println("Failed to click Subscribe: " + ex.getMessage());
		        test.fail("Failed to Click Subscribe");
		    }
		}
	    
		Thread.sleep(10000);
		
	    click.pressBack();
	    test.pass("Successfully Press Back");
	}
	
	@Test(priority=4,dependsOnMethods="TC_Play_Banner")
	public void TC_Swipe_VisionPlusOriginals() throws IOException, InterruptedException, TimeoutException {
	    click.clickBack();
	    test.pass("Successfully Clicked Back to Homepage");
	    
		Swipe swipe = new Swipe(android);
		
		swipe.swipeLeft();
	    test.pass("Successfully Swiped Vision Plus Originals");
	}
	
	@Test(priority=5,dependsOnMethods="TC_Swipe_VisionPlusOriginals")
	public void TC_Access_VisionPlusOriginals() throws IOException, InterruptedException, TimeoutException {
		click.clickVisionPlusOriginalsSeries();
	    test.pass("Successfully Clicked Vision Plus Originals");
	    
	    assertion.assertVODDetails();
	    test.pass("Successfully Assert VOD Details");
	    click.pressBack();
	}
	
	@Test(priority=6,dependsOnMethods="TC_Access_VisionPlusOriginals")
	public void TC_Access_WatchList() throws IOException, InterruptedException, TimeoutException {
		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//android.widget.TextView[contains(@text, 'Watchlist')]/following::android.view.View[1]");
	    scroll.scrollUntilElementFound(locator);

		click.clickVisionPlusOriginalsSeries();
	    test.pass("Successfully Clicked Vision Plus Originals");
	    
	    assertion.assertVODDetails();
	    test.pass("Successfully Assert VOD Details");
	}
	
	@Test(priority=7,dependsOnMethods="TC_Access_WatchList")
	public void TC_Play_VOD_WatchList() throws IOException, InterruptedException, TimeoutException {
		click.clickWatchVOD();
	    test.pass("Successfully Clicked Watch VOD");

	    Thread.sleep(10000);
	    
	    click.pressBack();
	}
	
	@Test(priority=8,dependsOnMethods="TC_Play_VOD_WatchList")
	public void TC_Swipe_Live_TV() throws IOException, InterruptedException, TimeoutException {
	    Thread.sleep(1000);

		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//android.widget.TextView[contains(@text, 'Your Favorite TV Channel')]/following::android.view.View[1]");

	    scroll.scrollUntilElementFound(locator);

	    click.clickViewAll();
	    
		Swipe swipe = new Swipe(android);
		
		swipe.swipeLeft();
	    test.pass("Successfully Swiped Live Tv");
	    
	    click.pressBack();
	}
	
	@Test(priority=9,dependsOnMethods="TC_Access_VisionPlusOriginals")
	public void TC_Click_Live_TV() throws IOException, InterruptedException, TimeoutException {
	    click.clickLinearChannelCluster();
	    test.pass("Successfully Clicked Live TV in Cluster Live TV");
	    
	    assertion.assertLiveTVPlayed();
	    test.pass("Successfully Assert Live TV Played");
	    
	    click.pressBack();
	}
	
	@Test(priority=10,dependsOnMethods="TC_Click_Live_TV")
	public void TC_Swipe_Top_10() throws IOException, InterruptedException, TimeoutException {   
		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//android.widget.TextView[contains(@text, 'Top 10 This Week')]/following::android.view.View[1]");
	    scroll.scrollUntilElementFound(locator);
	    	    	    
		Swipe swipe = new Swipe(android);
		
		swipe.swipeLeft();
	    test.pass("Successfully Swiped Top 10");
	}
	
	@Test(priority=11,dependsOnMethods="TC_Swipe_Top_10")
	public void TC_Click_Top_10() throws IOException, InterruptedException, TimeoutException {
	    click.clickVisionPlusOriginalsSeries();
		test.pass("Successfully Clicked VOD in Top 10");
	    assertion.assertVODDetails();
	    test.pass("Successfully Assert VOD Details");
	    
	    click.pressBack();
	}
	
	@Test(priority=12,dependsOnMethods="TC_Click_Top_10")
	public void TC_Click_Popular_Actors() throws IOException, InterruptedException, TimeoutException {   
		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//*[contains(@text,'Popular Actors')]");
	    scroll.scrollUntilElementFound(locator);
	    	    	    
	    click.clickPopularActors();
		test.pass("Successfully Clicked Popular Actors");
		
		System.out.println("Done click Popular Actors");
	}
	
	@Test(priority=13,dependsOnMethods="TC_Click_Popular_Actors")
	public void TC_Click_Watch_Popular_Actors_Series() throws IOException, InterruptedException, TimeoutException {   	    
	    click.clickPopularActorsSeries();
		test.pass("Successfully Clicked Popular Actors Series");
		
	    assertion.assertVODDetails();
	    test.pass("Successfully Assert VOD Details");
	    
	    click.clickWatchVOD();
		test.pass("Successfully Clicked Watch VOD");
		
		//wait for watch
		Thread.sleep(10000);
		
	    click.pressBack();
	}
}
