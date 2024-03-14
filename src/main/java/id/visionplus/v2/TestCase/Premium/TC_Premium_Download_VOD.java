package id.visionplus.v2.TestCase.Premium;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import id.visionplus.v2.PageObjects.VODDetailPage;
import id.visionplus.v2.PageObjects.VPlusOriginalsPage;
import expectj.TimeoutException;
import id.visionplus.v2.Action.Scroll;
import id.visionplus.v2.Action.Assertion;
import id.visionplus.v2.Action.Click;
import id.visionplus.v2.Action.Input;
import id.visionplus.v2.MainFunction.BaseTest;
import id.visionplus.v2.TestCase.General.TC_OpenApp;
import io.appium.java_client.android.AndroidDriver;

public class TC_Premium_Download_VOD  extends BaseTest{

	Click click = new Click();
	Assertion assertion = new Assertion();
	Input input = new Input();
  String testCaseType = System.getProperty("testCaseType");
//	String testCaseType = "PREMIUM_SPORT";

	@Test(priority = 1)
	public void TC_User_Can_Download_VOD() throws IOException, InterruptedException, TimeoutException {
		TC_OpenApp open_app = new TC_OpenApp();
		if ("PREMIUM_SPORT".equals(testCaseType)) {
			open_app.Choose_Login_As("PREMIUM_SPORT");
		} else if ("FREE".equals(testCaseType)) {
			open_app.Choose_Login_As("FREE");
		}
		Thread.sleep(2000);

		click.clickSampleVod();
		test.pass("Successfully clicked Open Vod");
		Thread.sleep(2000);
		assertion.assertSampleDetailVod();
		test.pass("Successfully  assert Vod Page");
		click.clickSampleVodEps1();
		test.pass("Successfully Clicked Eps 1 VOD");
		Thread.sleep(2000);
		assertion.assertSeriesTittleEps1();
		test.pass("Successfully  assert EPS 1 VOD");
		click.clickEpsDownloadVOD();
		test.pass("Successfully Clicked Download VOD");
		Thread.sleep(2000);
		assertion.assertPopupConfirmDownload();
		test.pass("Successfully assert popup download");
		click.clickConfirmDownload();
		test.pass("Successfully Clicked Confirmation DOwnload");
		Thread.sleep(2000);
		
	}

	@Test(priority = 2)
	public void TC_User_Cancel_DOwnload() throws IOException, InterruptedException, TimeoutException {

		click.clickCancelDownload();
		test.pass("Successfully Clicked Cancel Download");
		assertion.assertPopupConfirmDownload();
		Thread.sleep(2000);
		click.clickConfirmDownload();
		test.pass("Successfully Clicked Confirm Cancel");
		
	}
}


