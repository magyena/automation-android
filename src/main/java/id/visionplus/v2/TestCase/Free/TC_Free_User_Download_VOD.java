package id.visionplus.v2.TestCase.Free;

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
	Assertion assertion = new Assertion();
		String testCaseType = System.getProperty("testCaseType");
	//String testCaseType = "FREE";

	@Test //T222

	public void TC_User_free_Cant_Download_VOD() throws IOException, InterruptedException, TimeoutException {
	    TC_OpenApp open_app = new TC_OpenApp();
	    open_app.Choose_Login_As(testCaseType);

	    click.clickSampleVod();
	    test.pass("Successfully Clicked VOD");
	    assertion.assertSampleDetailVod();
	    test.pass("Successfully assert Detail VOD");
	    click.clickSampleVodEps1();
	    test.pass("Successfully Clicked Eps 1");
	    assertion.assertSeriesTittleEps1();
	    test.pass("Successfully assert Detail VOD EPS 1");
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
