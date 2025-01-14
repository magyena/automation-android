package id.visionplus.v2.TestCase.General;

import java.awt.Point;

/* Author		: Michael Liong
 * Created Date	: 4 April 2024
 * Updated by	: -
 * Updated Date	: -
 * Summary		: TC_Homepage
 * 1. Update Access Watchlist and make sure General Test Case run as Expected
 * */

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
    
//	String testCaseType = System.getProperty("testCaseType");
	
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
	public void TC_Access_Season1_From_Season_0() throws IOException, InterruptedException, TimeoutException {
		// Check if there is an element containing text "Season 0"
	    By seasonLocator = By.id("com.zte.iptvclient.android.idmnc:id/seasonSpinner");
	    if (android.findElements(seasonLocator).size() > 0) {
	        click.clickSeasonSpinner();
	        test.pass("Successfully Clicked on Season 0");
	        
	        click.clickSeason1();
	        test.pass("Successfully Clicked on Season 1");
	    }
	}
	
	@Test(priority=3,dependsOnMethods="TC_Access_Season1_From_Season_0")
	public void TC_Click_Banner() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Click_Banner");
	    click.pressBack();

		click.clickVODBanner();	    
		test.pass("Successfully Clicked Banner");
	    
	    assertion.assertContentDetails();
	    test.pass("Successfully Assert Banner Details");
	}
	
	@Test(priority=4,dependsOnMethods="TC_Click_Banner")
	public void TC_Play_Banner() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Play_Banner");

		int flag=0;
		
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
		        flag=1;
		    }
		}
		Thread.sleep(10000);

		if(flag==0){
		    click.pressBack();
		    test.pass("Successfully Press Back");
		}
	}
	
	@Test(priority=5,dependsOnMethods="TC_Play_Banner")
	public void TC_Swipe_VisionPlusOriginals() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Swipe_VisionPlusOriginals");

	    click.clickBack();
	    test.pass("Successfully Clicked Back to Homepage");
	    
		Swipe swipe = new Swipe(android);
		
		swipe.swipeLeft();
	    test.pass("Successfully Swiped Vision Plus Originals");
	}
	
	@Test(priority=6,dependsOnMethods="TC_Swipe_VisionPlusOriginals")
	public void TC_Access_VisionPlusOriginals() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Access_VisionPlusOriginals");

		click.clickVisionPlusOriginals();
	    test.pass("Successfully Clicked Vision Plus Originals");
	    
	    assertion.assertVODDetails();
	    test.pass("Successfully Assert VOD Details");
	}
	
	@Test(priority=7,dependsOnMethods="TC_Access_VisionPlusOriginals")
	public void TC_Add_To_Watchlist() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Add_To_Watchlist");

		click.clickSaveToWatchlist();
	    test.pass("Successfully Clicked Save VOD to Watchlist");
		
	    click.pressBack();
	}
	
	@Test(priority=8,dependsOnMethods="TC_Add_To_Watchlist")
	public void TC_Access_WatchList() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Access_WatchList");

		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//android.widget.TextView[contains(@text, 'Watchlist')]/following::android.view.View[1]");
	    scroll.scrollUntilElementFound(locator);

		System.out.println("Click Watchlist");

		click.clickWatchlist();
	    test.pass("Successfully Clicked Vision Plus Originals");
	    
	    assertion.assertVODDetails();
	    test.pass("Successfully Assert VOD Details");
	}
	
	@Test(priority=9,dependsOnMethods="TC_Access_WatchList")
	public void TC_Play_VOD_WatchList() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Play_VOD_WatchList");

		click.clickWatchVOD();
	    test.pass("Successfully Clicked Watch VOD");

	    Thread.sleep(10000);
	    
	    click.pressBack();
	}
	
	@Test(priority=10,dependsOnMethods="TC_Play_VOD_WatchList")
	public void TC_Delete_To_Watchlist() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Delete_To_Watchlist");

		click.clickDeleteToWatchlist();
	    test.pass("Successfully Clicked Remove VOD to Watchlist");
		
	    click.pressBack();
		System.out.println("done TC_Delete_To_Watchlist");
	}
	
	@Test(priority=11,dependsOnMethods="TC_Delete_To_Watchlist")
	public void TC_Swipe_Live_TV() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Swipe_Live_TV");

		Thread.sleep(1000);

		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//android.widget.TextView[contains(@text, 'Your Favorite TV Channel')]/following::android.view.View[2]");

	    scroll.scrollUntilElementFound(locator);

	    click.clickViewAll();
	    
	    Point start = new Point(984, 527);
	    Point end = new Point (238, 538);
		Swipe swipe = new Swipe(android);
		swipe.swipetoLeft(start, end);
	    test.pass("Successfully Swiped Live Tv");	    
	}

	@Test(priority=12,dependsOnMethods="TC_Swipe_Live_TV")
	public void TC_Click_Live_TV() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Click_Live_TV");
		
		click.clickLinearChannelCluster();
	    test.pass("Successfully Clicked Live TV in Cluster Live TV");
	    
	    assertion.assertLiveTVPlayed();
	    test.pass("Successfully Assert Live TV Played");
	    
	    click.pressBack();
	}
	
	@Test(priority=13,dependsOnMethods="TC_Click_Live_TV")
	public void TC_Click_TV_Love_Cinema() throws IOException, InterruptedException, TimeoutException {
	    click.pressBack();

		System.out.println("TC_Click_TV_Love_Cinema");

		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//android.widget.TextView[contains(@text, 'TV, Love, Cinema')]/following::android.view.View[2]");
	    scroll.scrollUntilElementFound(locator);
	    
	    click.clickTvLoveCinemaContent();
	    test.pass("Successfully Clicked Content in Cluster TV Live Cinema");

	    assertion.assertVODDetails();
	    test.pass("Successfully Assert VOD Details Page");
	}
	
	@Test(priority=14,dependsOnMethods="TC_Click_TV_Love_Cinema")
	public void TC_Watch_TV_Love_Cinema_Content() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Watch_TV_Love_Cinema_Content");

		click.clickWatchVOD();
	    test.pass("Successfully Clicked Watch in VOD Details");

	    Thread.sleep(10000);
	    
	    click.pressBack();
		click.clickBack();
	}
	
	@Test(priority=15,dependsOnMethods="TC_Watch_TV_Love_Cinema_Content")
	public void TC_Swipe_Top_10() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Swipe_Top_10");

		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//android.widget.TextView[contains(@text, 'Top 10 This Week')]/following::android.view.View[1]");
	    scroll.scrollUntilElementFound(locator);
	    	    	    
	    Point start = new Point(1002, 1852);
	    Point end = new Point (219, 1859);
		Swipe swipe = new Swipe(android);
		swipe.swipetoLeft(start, end);
	    test.pass("Successfully Swiped Top 10");
	}
	
	@Test(priority=16,dependsOnMethods="TC_Swipe_Top_10")
	public void TC_Click_Top_10() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Click_Top_10");

	    click.clickVisionPlusTop1Series();
		test.pass("Successfully Clicked VOD in Top 10");
	    assertion.assertVODDetails();
	    test.pass("Successfully Assert VOD Details");
	}
	
	@Test(priority=17,dependsOnMethods="TC_Click_Top_10")
	public void TC_Interact_in_VOD_Details() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Interact_in_VOD_Details");

	    TC_VOD_Details vod_details = new TC_VOD_Details();
	    
		System.out.println("TC_User_Like_VOD");
	    vod_details.TC_User_Like_VOD();

		System.out.println("TC_User_Disike_VOD");
	    vod_details.TC_User_Disike_VOD();
	    
		System.out.println("TC_User_Cannot_Download");
	    vod_details.TC_User_Cannot_Download();
	    
		System.out.println("TC_User_Can_See_Synopsis");
	    vod_details.TC_User_Can_See_Synopsis();
	    
	    click.clickBack();
	    click.pressBack();
	}
	
	@Test(priority=18,dependsOnMethods="TC_Interact_in_VOD_Details")
	public void TC_Click_Popular_Actors() throws IOException, InterruptedException, TimeoutException { 
		System.out.println("TC_Click_Popular_Actors");

		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//*[contains(@text,'Popular Actors')]");
	    scroll.scrollUntilElementFound(locator);
	    	    	    
	    click.clickPopularActors();
		test.pass("Successfully Clicked Popular Actors");
		
		Thread.sleep(2000);
	}
	
	@Test(priority=19,dependsOnMethods="TC_Click_Popular_Actors")
	public void TC_Click_Watch_Popular_Actors_Series() throws IOException, InterruptedException, TimeoutException {  
		System.out.println("TC_Click_Watch_Popular_Actors_Series");

		Thread.sleep(2000);

	    click.clickPopularActorsSeries();
		test.pass("Successfully Clicked Popular Actors Series");
		
	    assertion.assertVODDetails();
	    test.pass("Successfully Assert VOD Details");
	    
	    click.clickWatchVOD();
		test.pass("Successfully Clicked Watch VOD");
		
		//wait for watch
		Thread.sleep(10000);
		
	    click.pressBack();
	    click.pressBack();
	}
	
	@Test(priority=20,dependsOnMethods="TC_Click_Watch_Popular_Actors_Series")
	public void TC_Click_Comedy() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Click_Comedy");

	    click.pressBack();

		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//*[contains(@text,'Indonesian Comedy Series')]/following::android.view.View[1]");
	    scroll.scrollUntilElementFound(locator);
	    	    	    
		Thread.sleep(2000);

	    click.clickComedyContent();
		test.pass("Successfully Clicked Indonesian Comedy Series");
		assertion.assertVODDetails();
		test.pass("Successfully Assert VOD Details Indonesian Comedy Series");
	}
	
	@Test(priority=21,dependsOnMethods="TC_Click_Comedy")
	public void TC_Watch_Comedy_Content() throws IOException, InterruptedException, TimeoutException {
		System.out.println("TC_Watch_Comedy_Content");

		Thread.sleep(2000);

		click.clickWatchVOD();
	    test.pass("Successfully Clicked Watch in VOD Details");

	    Thread.sleep(10000);
	    
	    click.pressBack();
	}
}
