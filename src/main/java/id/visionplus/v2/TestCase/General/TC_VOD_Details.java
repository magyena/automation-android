package id.visionplus.v2.TestCase.General;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.MainFunction.BaseTest;

public class TC_VOD_Details extends BaseTest{
	
	Click click = new Click();
	Assertion assertion = new Assertion();	
	@Test(priority=1)
	public void TC_User_Like_VOD() throws IOException, InterruptedException, TimeoutException {
		TC_Homepage tc_homePage = new TC_Homepage();
		tc_homePage.TC_Access_VOD_Detail();
		
	    click.clickLikeVOD();
	    test.pass("Successfully Clicked Like Button");
	    
	    Thread.sleep(2000);
	}
	
	@Test(priority=2, dependsOnMethods="TC_User_Like_VOD")
	public void TC_User_Disike_VOD() throws IOException, InterruptedException, TimeoutException {
		click.clickDislikeVOD();
	    test.pass("Successfully Clicked Dislike Button");
	}
	
	@Test(priority=2,dependsOnMethods="TC_User_Like_VOD")
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
	
	@Test(priority=2,dependsOnMethods="TC_User_Like_VOD")
	public void TC_User_Cannot_Download() throws IOException, InterruptedException, TimeoutException {
		click.clickEps1VOD();
	    test.pass("Successfully Clicked Episode 1 VOD");

	    assertion.assertDownloadButtonNotShown();
	    test.pass("Successfully Assert Download Button Not Shown");
	    
	    click.pressBack();
	    test.pass("Successfully Press Back Button");
	}
	
	@Test(priority=2,dependsOnMethods="TC_User_Like_VOD")
	public void TC_User_Can_See_Synopsis() throws IOException, InterruptedException, TimeoutException {
		click.clickEps1VOD();
	    test.pass("Successfully Clicked Episode 1 VOD");

		click.clickSynopsis();
	    test.pass("Successfully Clicked Synopsis");
	}
	
	@Test(priority=2,dependsOnMethods="TC_User_Like_VOD")
	public void TC_User_Can_Watch_Trailer() throws IOException, InterruptedException, TimeoutException {
		click.clickWatchTrailer();
	    test.pass("Successfully Clicked Trailer Button");

	    Thread.sleep(10000);
	    
	    click.pressBack();
	    test.pass("Successfully Press Back Button");
	}
	
	@Test(priority=3,dependsOnMethods="TC_User_Like_VOD")
	public void TC_User_can_Add_To_Watchlist() throws IOException, InterruptedException, TimeoutException {
		click.clickSaveToWatchlist();
	    test.pass("Successfully Clicked Save VOD Button");
	    
	    click.pressBack();
	    test.pass("Successfully Press Back Button");
	    
		Scroll scroll = new Scroll(android);
		By locator = By.xpath("//*[contains(@text,'Watchlist')]");
	    scroll.scrollUntilElementFound(locator);
	    
	    assertion.assertVODinWatchlist();
	    test.pass("Successfully Assert VOD in Watchlist");
	    	    
	    click.clickVisionPlusOriginalsSeries();
	    test.pass("Successfully Clicked VOD Vision Plus Originals");
	    
		click.clickSaveToWatchlist();
	    test.pass("Successfully Clicked unSave VOD Button");
	}
}
