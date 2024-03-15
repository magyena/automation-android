package id.visionplus.v2.TestCase.General;

import java.io.IOException;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.MainFunction.BaseTest;

public class TC_Search extends BaseTest{
	
	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
    // Get the test case type from TestNG parameters
    String testCaseType = System.getProperty("testCaseType");
<<<<<<< HEAD
 
	
=======
//	String testCaseType = "PREMIUM_SPORT";
>>>>>>> a2faab1 (First Push to New Branch)
	@Test(priority=1)
	public void TC_Access_Search() throws IOException, InterruptedException, TimeoutException {
        TC_OpenApp open_app = new TC_OpenApp();
        if ("PREMIUM_SPORT".equals(testCaseType)) {
            open_app.Choose_Login_As("PREMIUM_SPORT");
        } else if ("FREE".equals(testCaseType)) {
            open_app.Choose_Login_As("FREE");
        }
        Thread.sleep(2000);

        click.clickMenuButton();
        test.pass("Successfully Clicked Menu Button");

        Thread.sleep(2000);

        click.clickSearchButton();
        test.pass("Successfully Clicked Search Button");
        
        assertion.assertSearchPage();
        test.pass("Successfully Assert Search Page");
        
	}
	
	@Test(priority=2,dependsOnMethods="TC_Access_Search()")
	public void TC_user_can_search_VOD() throws IOException, InterruptedException, TimeoutException {
		input.clearSearch();

		click.clickSearchField();
		test.pass("Successfully Clicked Search Field");
		
		input.inputSearch("Arab Maklum");
		test.pass("Successfully Input Search Field with Valid Keyword");
		
		assertion.assertSearchVOD();
		test.pass("Successfully Assert VOD Search Result");
		
		click.clickSearchVOD();
		test.pass("Successfully Clicked Search VOD");
		
		assertion.assertVODDetails();
		test.pass("Successfully Assert VOD Search Details");
		
		click.pressBack();
	}
	
	@Test(priority=3,dependsOnMethods="TC_user_can_search_VOD")
	public void TC_user_can_search_LiveTv() throws IOException, InterruptedException, TimeoutException {
		input.clearSearch();
		
		click.clickSearchField();
		test.pass("Successfully Clicked Search Field");
		
		input.inputSearch("RCTI");
		test.pass("Successfully Input Search Field with Valid Keyword");
		
		android.hideKeyboard();
		
		assertion.assertSearchLiveTv();
		test.pass("Successfully Assert Live TV Search Result");
		
		click.clickSearchLiveTv();
		test.pass("Successfully Clicked Search Live Tv");
		
		assertion.assertLiveTVPlayed();
		test.pass("Successfully Assert Live Tv Search Played");
		
		Thread.sleep(10000);
		
		click.pressBack();
	}
	
	@Test(priority=3,dependsOnMethods="TC_user_can_search_VOD")
	public void TC_user_cannot_search_with_invalid_keyword() throws IOException, InterruptedException, TimeoutException {
		input.clearSearch();
		
		click.clickSearchField();
		test.pass("Successfully Clicked Search Field");
		
		input.inputSearch("RCTIasdf");
		test.pass("Successfully Input Search Field with Invalid Keyword");
		
		android.hideKeyboard();

		assertion.assertSearchNotFound();
		test.pass("Successfully Assert Text Warning Search not Found");
	}
}
	
