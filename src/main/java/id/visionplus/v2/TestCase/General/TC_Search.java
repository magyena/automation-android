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
	
	@Test(priority=1)
	public void TC_user_can_search_VOD() throws IOException, InterruptedException, TimeoutException {
		TC_Menu menu = new TC_Menu();
		menu.TC_Access_Search();
		
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
	
	@Test(priority=2,dependsOnMethods="TC_user_can_search_VOD")
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
	
	@Test(priority=2,dependsOnMethods="TC_user_can_search_VOD")
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
	
