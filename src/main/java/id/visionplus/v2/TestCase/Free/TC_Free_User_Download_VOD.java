package id.visionplus.v2.TestCase.Free;
/* Author		: Fatah Alim
 * Created Date	: 2 April 2024
 * Updated by	: -
 * Updated Date	: 2 Mei 2024
 * Summary		: TC_Free_User_Download_VOD
 * 1. Update Scenario free Cant Download 
 * */
import java.io.IOException;

import org.testng.annotations.Test;

import expectj.TimeoutException;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.Action.Tap;
import id.visionplus.v2.Action.Toggle;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_OpenApp;
import id.visionplus.v2.TestCase.General.TC_Settings;

public class TC_Free_User_Download_VOD extends BaseTest {
	
	Click click = new Click();
	Input input = new Input();
	Assertion assertion = new Assertion();
	String testCaseType = System.getProperty("testCaseType");
//	String testCaseType = "FREE";

	@Test //T222

	public void TC_User_free_Cant_Download_VOD() throws IOException, InterruptedException, TimeoutException {
	    TC_OpenApp open_app = new TC_OpenApp();
	    open_app.Choose_Login_As(testCaseType);

	    click.clickMenuButton();
		click.clickSearchButton();
		input.clearSearch();

		click.clickSearchField();
		test.pass("Successfully Clicked Search Field");

		input.inputSearch("Cinta Di Balik Awan");
		test.pass("Successfully Input Search Field with Valid Keyword");

		click.clickVodCintaDiBalikAwan();
		test.pass("Successfully clicked VOD Eps 1");

		click.clickVodDownloadEps1();
		test.pass("Successfully clicked Eps 1 VOD");

		assertion.assertTitleVODEpisode();
		test.pass("Successfully assert title episode");

		try {
	        assertion.assertDownloadTextNotPresent();
	        test.pass("Download text is not present.");
	    } catch (AssertionError e) {
	        test.fail("Download text is present on the page.");
	        throw new AssertionError("Test case failed due to assertion failure.", e);
	    }
		
	    Thread.sleep(5000);
	}

}
